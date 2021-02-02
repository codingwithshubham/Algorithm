package matrix;

import java.io.*;
import java.util.*;

public class SpiralDisplay {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[][] arr = new int[row][col];
		
		for(int i=0; i<row; i++){
		    for(int j=0; j<col; j++){
		        arr[i][j] = sc.nextInt();
		    }
		}
		
		
		int count = row*col;
		int rowMin = 0, rowMax = row-1, colMin = 0, colMax= col-1;
		
		while(count>0){
		    
		    for(int i=rowMin; i<= rowMax; i++){
		        System.out.println(arr[i][colMin]);
		         count--;
		    }
		    colMin++;
		    
		    for(int i=colMin; i<=colMax; i++){
		        System.out.println(arr[rowMax][i]);
		         count--;
		    }
		    rowMax--;
		    
		    for(int i=rowMax; i>=rowMin && count>0; i--){
		        System.out.println(arr[i][colMax]);
		         count--;
		    }
		    colMax--;
		    
		    for(int i=colMax; i>=colMin && count>0; i--){
		        System.out.println(arr[rowMin][i]);
		         count--;
		    }
		    rowMin++;
		}
	}

}
