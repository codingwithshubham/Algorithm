
public class GCD {

	public static void main(String[] args) {
		
		int n1 = 5, n2 = 45;
		
		bruteGcd(n1,n2); 
	// time : O(min(n1,n2))
	// space : O(1);
		
		System.out.println(recursiveGcd(n1, n2));
		// time : O(log(max(n1,n2)))
		// space : O(log(max(n1,n2)))
		
		gcdOptimised(n1, n2);
		// time : O(log(max(n1,n2)))
		// space : O(1)
		
		// note for gcd(n1,n1-n2)
		
		lcm(n1, n2);
			
	}
	
	static void lcm(int n1, int n2) {
		int max, min,i = 1;
		if(n1< n2) {
			max = n2;
			min = n1;
		}
		else
		{
			max = n1;
			min = n2;
		}
			

		while(i<= min) {
			if(max*i% min == 0) {
				System.out.println("lcm"+ max*i);
				break;
			}
			i++;
//			if(i%n1 == 0 && i%n2 == 0) {
//				System.out.println("lcm"+ i);
//				break;
//			}
//			i++;
		}
	}
	
	static void gcdOptimised(int n1, int n2) {
		int num = n1;
		int div = n2;
		
		//special case if div = 0
		if(div == 0) {
			System.out.println(num);
			return;
		}
			
		while(num%div != 0) {
			int temp = num%div;
			num = div;
			div = temp;
		}
		
		System.out.println(div);
	}
	
	
	static int recursiveGcd(int n1, int n2) {
		
		//special case for notdefined i.e. n1%0
		if(n2 == 0)
			return n1;
		
		//base case
		if(n1%n2 == 0)
			return n2;
		
		return recursiveGcd(n2, n1%n2);
		
	}
	
	static void bruteGcd(int n1, int n2) {
			
		//corner case;
		if(n1==0) {
			System.out.println(n2);
			return;
		}
		if(n2==0) {
			System.out.println(n1);
			return;
		}
			
		int min;
		if(n1>n2)
			min = n2;
		else
			min = n1;
		
		int result = 1; //if n1 and n2 are coprime
		
		for(int i=2; i<= min; i++) {
			if(n1%i == 0 && n2%i == 0)
				result = i;
		}
		
		System.out.println(result);
	}

}
