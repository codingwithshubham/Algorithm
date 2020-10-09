package baseofno;
import java.util.*;
/*
 * print num2-num1 in given base
 */
public class Subtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int preBorrow = 0;
		int ans = 0;
		int pow = 0;
		
		//skipping case when num2 < num1 as its given that num2 >= num1
		while(num2 != 0) {
			
			int digit1 = num1%10;
			int digit2 = num2%10;
			int borrow =0;
			
			digit2 -= preBorrow;
			
			if(digit2 < digit1){
				borrow =1;
				digit2 += base;
			}
			
			int diff = digit2 - digit1;
			
			ans += diff*Math.pow(10, pow);

			pow++;
			preBorrow = borrow;
			num1 /= 10;
			num2 /= 10;
		}
		
		System.out.println(ans);	

	}

}
