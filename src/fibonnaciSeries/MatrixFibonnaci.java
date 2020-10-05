package fibonnaciSeries;

import java.util.*;
public class MatrixFibonnaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0){
            int n = sc.nextInt();

            System.out.print(fib(n));
        }
        // 0 1 1 2 3 5 8 13 21 34

    }

    static long fib(int n){
        if(n<=1)
            return n;

        long[][] matrix = new long[][]{{1,1},{1,0}};
        power(matrix, n-1); 
        return matrix[0][0];
    }
    

    static void power(long[][] f, int n){
        if(n==1)
            return;
       
        power(f, n/2);

        multiply(f,f);

        if(n%2 != 0){
            long[][] m = new long[][]{{1,1}, {1,0}};
            multiply(f,m);        
        }  

    }
    // 1 1  *  1 1
    // 1 1     1 1

    static void multiply(long[][]f, long[][]m){
       long a,b,c,d;
       a = f[0][0]*m[0][0] + f[0][1]*m[1][0];
       b = f[0][0]*m[0][1] + f[0][1]*m[1][1];
       c = f[1][0]*m[0][0] + f[1][1]*m[1][0];
       d = f[1][0]*m[0][1] + f[1][1]*m[1][1];

       f[0][0] = a;
       f[0][1] = b;
       f[1][0] = c;
       f[1][1] = d;  
    }
    
}

