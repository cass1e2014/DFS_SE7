/**
 * Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 *
 *这道求岛屿数量的题的本质是求矩阵中连续区域的个数
 * @author cassie9082
 *
 */
public class NumberOfIslands {
	//对每一个陆地区域做一次dfs
	//每次dfs中将已经遍历的陆地网格“1”变为水域网格“0”（防止再次遍历导致重复）
	//对每次dfs计数，总共dfs的次数即为岛屿总数
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    result ++;
                    numIslandsHelper(grid, visited, i, j, rows, cols);
                }
            }
        }
        return result;
    }
    
    public void numIslandsHelper(char[][] grid, boolean[][] visited, int i, int j, int rows, int cols){
        if(i < 0 || i >= rows){
            return;
        }
        if(j < 0 || j >= cols){
            return;						
        }
        if(visited[i][j]){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;//mark the visit to be true
        
        numIslandsHelper(grid, visited, i-1, j, rows, cols);
        numIslandsHelper(grid, visited, i+1, j, rows, cols);
        numIslandsHelper(grid, visited, i, j-1, rows, cols);
        numIslandsHelper(grid, visited, i, j+1, rows, cols);
    }
	
}
