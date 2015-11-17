/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [
  [0,0,0],
  [0,1,0],
  [0,0,0]
	]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * 
 * @author cassie9082
 * 
 */
public class UniquePathsII {
	// 2-D solution
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		// 第一格或最后一格遇到障碍物
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}

		int[][] dp = new int[m][n];

		// fill the first row,如果遇到障碍物，变为0，break
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 0) {
				dp[0][i] = 1;
			} else {
				dp[0][i] = 0;
				break;
			}
		}

		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = 1;
			} else {
				dp[i][0] = 0;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
