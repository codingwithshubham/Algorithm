/*
 * score = no of 1 in left + no of 0 in right
 * divide string having 0,1 such that score is max and also any of 2 parts can't be empty
 */
public class ScoreCount {

	public static void main(String[] args) {
		String s = "11111011";
		
		int zeroes =0, max = 0, one =0, index =-1;
		
		for(int i=0; i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '0')
				zeroes++;
				
		}
		
		for(int i=0; i<s.length()-1; i++) {
			char c = s.charAt(i);
			
			if(c == '1')
				one++;
			else
				zeroes--;
			
			int score = one + zeroes;
			
			if(score > max) {
				max = score;
				index = i;
			}
		}
		
		System.out.println(index+" "+max);

	}

}
