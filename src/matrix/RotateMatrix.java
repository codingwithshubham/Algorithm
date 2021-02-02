package matrix;

import java.io.*;
import java.util.*;

//rotate matrix 90degree clockwise
public class RotateMatrix {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[][] ans = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0, k=n-1; j<n && k>=0; j++, k--){
                ans[i][j] = arr[k][i];
            }
        }
        
        display(ans);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
