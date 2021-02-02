package dp;

//leetcode cherryPickup2 by memoization
class Solution {
	
    public int cherryPickup(int[][] grid){
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                for(int k=0; k<grid[0].length; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return cherryPickup(grid, 0, 0, grid[0].length-1, dp);
    }
    
    public int cherryPickup(int[][] grid, int row, int col1, int col2, int[][][] dp) {
        
        if(row == grid.length)
            return 0;
        
        if(dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        
        int[] dir = {-1,0,1};
        
        int max = Integer.MIN_VALUE;
        int cur = grid[row][col1] + grid[row][col2];
        if(col1 == col2)
            cur = grid[row][col1];
        
        //9 comb
        for(int d1: dir){
            
            for(int d2: dir){
                
                if(isAllowed(grid, col1+d1) &&isAllowed(grid, col2+d2)){
                        max = Math.max(max, cur + cherryPickup(grid, row+1, col1+d1, col2+d2, dp));
                }
            }
        }
        
        return dp[row][col1][col2] = max;
        
    }
    
    boolean isAllowed(int[][] grid, int col){
        if(col>=0 && col<grid[0].length)
            return true;
        
        return false;
    }
}
