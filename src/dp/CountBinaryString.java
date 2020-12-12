package dp;
import java.util.*;

/*
 * 1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
 */

public class CountBinaryString {
	
	public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n==0)
        System.out.println(n);
    else
        System.out.println(f(n)+f(n+1));
 }
 
 static int f(int n){
     int a = 0;
     int b = 1;
     int c=a+b;
     
     if(n==0 || n==1)
        return n;
        
     for(int i=2; i<=n; i++){
         c=a+b;
         a=b;
         b=c;
     }
     
     return c;
 }

}
