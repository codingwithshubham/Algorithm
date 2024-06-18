import java.util.concurrent.*;

public class Main
{
	public static void main(String[] args) {
		Semaphore read = new Semaphore(10);
		Semaphore write = new Semaphore(1);
		Test test = new Test();
		
		WriterThread[] w = new WriterThread[2];
		ReaderThread[] r = new ReaderThread[10];
		
		for(int idx=0; idx<r.length; idx++){
		    r[idx] = new ReaderThread(test, idx+"", read, write);
		}
		
		for(int idx=0; idx<w.length; idx++){
		    w[idx] = new WriterThread(test, idx+"", read, write);
		}
		
		for(ReaderThread r1: r){
		    r1.start();
		}
		
		for(WriterThread r1: w){
		    r1.start();
		}
		
	}
}

class Test {
    int[] arr = new int[10];
    int readCount = 0;
    
    void read() {
        System.out.println("R "+Thread.currentThread().getName() +" " +arr[0]);
    }
    
    void write() {
        int val = 5;
        arr[0] = val;
        System.out.println("W "+val+" "+Thread.currentThread().getName() +" " +arr[0]);
    }
}

class ReaderThread extends Thread{
    Test test;
    Semaphore read;
    Semaphore write;
    
    ReaderThread(Test test, String name, Semaphore read, Semaphore write){
        super("ReaderThread "+name);
        this.test = test;
        this.read = read;
        this.write = write;
    }
    
    public void run() {
        try{
            read.acquire();
        } catch(Exception e){
            
        }
        
        synchronized(test) {
            if(test.readCount == 0){
                
                try{
                    write.acquire();
                    System.out.println("Acquire Write lock "+Thread.currentThread().getName());
                } catch(Exception e){
                    
                }
                
            }
        }
        
        test.readCount++;
        
        test.read();
        
        read.release();
        test.readCount--;
        if(test.readCount == 0){
            System.out.println("Release Write lock");
            write.release();
        }
    }
}


class WriterThread extends Thread{
    Test test;
    Semaphore read;
    Semaphore write;
    
    WriterThread(Test test, String name, Semaphore read, Semaphore write){
        super("WriterThread "+name);
        this.test = test;
        this.read = read;
        this.write = write;
    }
    
    public void run() {
        try{
            // synchronized(test) {
                
                //System.out.println("B "+write.availablePermits());
                write.acquire();
                System.out.println("Acquire Write lock "+Thread.currentThread().getName());
                //System.out.println("A "+write.availablePermits());
            // }
            
        } catch(Exception e){
            
        }
        test.write();
        System.out.println("Release Write lock "+Thread.currentThread().getName());
        //System.out.println("BR "+write.availablePermits());
        write.release();
        //System.out.println("AR "+write.availablePermits());
    }
}
