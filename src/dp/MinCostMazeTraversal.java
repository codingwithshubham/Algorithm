package dp;
import java.util.*;

/*
 * 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
     right cell).
7. You are required to traverse through the matrix and print the cost of path which is least costly.
 */

public class MinCostMazeTraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int[][] maze = new int[sc.nextInt()][sc.nextInt()];
        
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        
        minCost(maze);
    }
    
    static void minCost(int[][] maze){
        
        int[][] costMaze = new int[maze.length][maze[0].length];
        
        for(int row=maze.length-1; row>=0; row--){
            for(int col=maze[0].length-1; col>=0; col--){
                
                costMaze[row][col] = maze[row][col];
                
                int min = Integer.MAX_VALUE;
                
                if(row+1<costMaze.length){
                    min = Math.min(min, costMaze[row+1][col]);    
                }
                if(col+1<costMaze[0].length){
                    min = Math.min(min, costMaze[row][col+1]);  
                }
                
                if(min != Integer.MAX_VALUE)
                    costMaze[row][col] += min;
            }
        }
        
        System.out.println(costMaze[0][0]);
    }

}
