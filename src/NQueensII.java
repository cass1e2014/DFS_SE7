/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 * @author cassie9082
 * 
 */
/**
 * 与I相比基本类似，但是记录的结果不一样
 * 因为涉及到递归，result传进去引用类型（List，数组之类的）才能在层层递归中得以保存，所以这里使用一个长度为1的数组帮助计数。
 * 
 * 当然，也可以使用一个全局变量来帮助计数。
 * 
 * @author cassie9082
 * 
 */
public class NQueensII {
	public int totalNQueens(int n) {
		int[] result = {0};
		
		if(n < 0){
			return result[0];
		}
		
		int[] columnVal = new int[n];
		DFS_Helper(n, result, 0, columnVal);
		return result[0];
	}
	
	public void DFS_Helper(int n, int[] result, int row, int[] columnVal){
		if(row == n){
			result[0] += 1;
		}else{
			for(int i = 0 ;i < n; i ++){
				columnVal[row] = i;//(row,columnVal[row)==>(row,i)  [把每一行的每一格都会试试］
				if(isValid(row, columnVal)){
					DFS_Helper(n, result, row+1, columnVal);
				}
			}
		}	
	}
	
	public boolean isValid(int row, int[] columnVal){
		//for loop传入的每一行
		for(int i = 0; i < row; i++){
			if(columnVal[row] == columnVal[i] || Math.abs(columnVal[row] - columnVal[i]) == row - i){
				return false;
			}
		}
		return true;
	}
}
