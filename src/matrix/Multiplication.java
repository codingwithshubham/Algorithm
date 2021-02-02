package matrix;

import java.io.*;
import java.util.*;

public class Multiplication{

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner sc = new Scanner(System.in);
    int row1 = sc.nextInt();
    int col1 = sc.nextInt();
    
    int[][] arr1 = new int[row1][col1];
    
    for(int i=0; i<row1; i++){
        for(int j=0; j<arr1[i].length; j++){
            arr1[i][j] = sc.nextInt();
        }
    }
    
    int row2 = sc.nextInt();
    int col2 = sc.nextInt();
    
    int[][] arr2 = new int[row2][col2];
    
    for(int i=0; i<row2; i++){
        for(int j=0; j<arr2[i].length; j++){
            arr2[i][j] = sc.nextInt();
        }
    }
    
    if(col1 == row2){
        int[][] prd = new int[row1][col2];
        
        for(int i=0; i<row1; i++){
            for(int j=0; j<col2; j++){
                for(int k=0; k<col1; k++){
                    prd[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        for(int i=0; i<row1; i++){
        for(int j=0; j<prd[i].length; j++){
            System.out.print(prd[i][j]+" ");
        }
        System.out.println();
    }
        
      
    }
    else{
        System.out.print("Invalid input");
    }
    
    
 }

}
