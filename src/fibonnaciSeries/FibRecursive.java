package fibonnaciSeries;

import java.util.*;

public class FibRecursive {
    public static void main(String[] args) {
        System.out.print(fib(9));
    }
    
    // eg.   0 1 1 2 3 5 8 13
    static int fib(int n){
        int a = 0;
        int b = 1;
        int c = -1;  
        if(n==0)
            return a;
        if(n==1)
            return b;
        for(int i=2; i<=n; i++){
            c = a+b;
            a= b;
            b= c;
        }
        return c;
    }
    
}
