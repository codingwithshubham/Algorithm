
public class BinomialCoefficient {
	
	public static void main(String[] args) {
		int n = 5;
		int r = 3;
		
		int ncrprevious = 1;
		
		if(n-r < r)
			r = n-r;
		
		for(int i=1; i<=r; i++) {
			System.out.print(ncrprevious+" ");
			int ncr = ncrprevious*(n-(i-1))/i;
			ncrprevious = ncr;
			
		}
		
		System.out.println(ncrprevious);
	}

}
