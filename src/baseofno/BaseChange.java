package baseofno;
import java.util.*;

/*
 * change num from base b1 to base b2
 */

public class BaseChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		
		int decNum = 0;
		int pow = 0;
		
		while(num !=0) {
			int digit = num % 10;
			decNum += digit*Math.pow(b1, pow);
			
			pow++;
			num /= 10;
		}
		
		pow = 0;
		int ans =0;
		
		while(decNum !=0) {
			int rem = decNum%b2;
			ans += rem*Math.pow(10, pow);
			pow++;
			decNum /= b2;
		}
		
		System.out.println(ans);

	}

}
