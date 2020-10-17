package matrix;
import java.util.*;
/*
 * both rows and columns are sorted
 */

public class SearchSortedMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int num = sc.nextInt();
		
	// Time : O(n+m)
		search(arr, num);
	// other approach applying binary at each row O(nlogn)
	}
	
	public static void search (int[][] arr, int num) {
		
		int r = 0;
		int c = arr[0].length-1;
		boolean found = false;
		
		while(r<arr.length && c>=0) {
			int mid = arr[r][c];

			if(mid == num) {
				found = true;
				break;
			}
			else if(mid<num)
				r++;
			else
				c--;
		}
		
		if(found)
		{
			System.out.println(r+" "+c);
		}
		else
			System.out.println("not found");
	}

}
