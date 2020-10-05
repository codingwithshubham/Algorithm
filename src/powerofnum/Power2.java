package powerofnum;

public class Power2 {
    public static void main(String[] args) {
  
        System.out.println(power(5,11));
    }
   
    static int power(int n, int m){
        if(m==0)
            return 1;
        if(m==1)
            return n;
        int temp = power(n, m/2);

        if(m%2 == 0)
            return temp*temp;
        else
            return temp*temp*n;
    }
    
}

//time: O(logn)
//space : O(logn) (stack)

