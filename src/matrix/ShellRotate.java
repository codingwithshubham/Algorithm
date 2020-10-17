package matrix;
import java.util.*;

public class ShellRotate {

	public static void main(String[] args) {
		int[][] arr= new int[][] {{11,12,13,14,15,16},{21,22,23,24,25,26},{31,32,33,34,35,36},{41,42,43,44,45,46},
									{51,52,53,54,55,56},{61,62,63,64,65,66}};
			
		display(arr);
		System.out.println();
		
		int s = 3;
		
		int start = s-1, end = arr.length-1 -(s-1);
	
		for(int j=start; j<=end; j++) {
			for(int i=j; i<=end; i++) {
				if(j==start || i==end) {
					int temp = arr[j][i];
					arr[j][i] = arr[i][j];
					arr[i][j] = temp;
				}
			}
		}
//		System.out.println();
//		display(arr);
		
		for(int i=start; i<=end; i++) {
			int temp = arr[i][start];
			arr[i][start] = arr[i][end];
			arr[i][end] = temp;
		}
//		System.out.println();
//		display(arr);
	
		int l = start+1;
		int r = end-1;
		while(l<r) {
			int temp = arr[start][l];
			arr[start][l] = arr[start][r];
			arr[start][r] = temp;
			l++;
			r--;
		}
		
		l = start+1;
		r = end-1;
		while(l<r) {
			int temp = arr[end][l];
			arr[end][l] = arr[end][r];
			arr[end][r] = temp;
			l++;
			r--;
		}
		
		display(arr);

	}
	
	static void display(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
