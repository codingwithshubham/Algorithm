package baseofno;
import java.util.*;

public class Multiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int ans = 0;
		int pow = 1;
		
		while(num2 != 0) {
			int digit = num2%10;
			
			int prd = multiplyByNum1(base, num1, digit);
			
			ans = sum(base, prd*pow, ans);
			
			pow = pow*10;
			num2 /= 10;
		}
		System.out.println(ans);

	}
	
	static int multiplyByNum1(int base, int num1, int digit) {
		int ans = 0;
		int carry = 0;
		int pow =1;
		
		while(num1!=0 || carry!=0) {
			int digit1 = num1%10;
			
			int sum = digit1 * digit +carry;
			
			carry = sum/base;
			sum = sum%base;
			
			ans += sum*pow;
			
			pow *= 10;
			num1 /= 10;
		}
		return ans;
	}
	
	static int sum(int base, int num1, int num2) {
		int preCarry = 0;
		int ans = 0;
		int pow = 0;
		
		while(num1!=0 || num2!=0 || preCarry!=0) {
			int digit1 = num1%10;
			int digit2 = num2%10;
			int carry = 0;
			
			int sum = digit1 + digit2 + preCarry;
			
			if(sum>=base) {
				carry = sum/base;
				sum = sum%base;
			}
			
			ans += sum*Math.pow(10, pow);
			
			preCarry = carry;
			pow++;
			num1 /= 10;
			num2 /= 10;
		}
		
		return ans;
	}

}
