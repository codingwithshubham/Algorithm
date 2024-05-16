public class Main
{
	public static void main(String[] args) {
	    Test test = new Test();
	    
		MyThread t1 = new MyThread("EvenThread", test, true); //even
		MyThread t2 = new MyThread("oddThread", test, false); // odd
		
		t1.start();
		t2.start();
	}
}

class MyThread extends Thread {
    Test test;
    boolean isEven;
    
    public void run() {
        test.print(isEven);
    }
    
    MyThread(String name, Test test, boolean even) {
        super(name);
        this.test = test;
        isEven = even;
    }
}

class Test {
    public static int count = 1;
    
    public synchronized void print(boolean isEven) {
        while(count < 2){
            
            if((count&1) == 1){
                if(isEven){
                    try{
                        this.wait();
                    }
                    catch(Exception e){
                        
                    }
                    
                }
            } else {
                if(!isEven){
                    try{
                        this.wait();
                    }
                    catch(Exception e){
                        
                    }
                }
            }
            
            System.out.println(Thread.currentThread().getName()+" "+count);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                
            }
            this.notifyAll();
            count++;
        }
    } 
}
