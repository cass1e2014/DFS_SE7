import java.util.List;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.（同一行、同一列、同一斜线上的皇后都会自动攻击）
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],
 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */

/**
 * 回溯算法也叫试探法，它是一种系统地搜索问题的解的方法。回溯算法的基本思想是：从一条路往前走，能进则进，不能进则退回来，换一条路再试。 1) 算法开始,
 * 清空棋盘，当前行设为第一行，当前列设为第一列
 * 
 * 2) 在当前行，当前列的位置上判断是否满足条件(即保证经过这一点的行,列与斜线上都没有两个皇后)，若不满足，跳到第4步
 * 
 * 3) 在当前位置上满足条件的情形：
 * 
 * 在当前位置放一个皇后，若当前行是最后一行，记录一个解；
 * 
 * 若当前行不是最后一行，当前行设为下一行, 当前列设为当前行的第一个待测位置；
 * 
 * 若当前行是最后一行，当前列不是最后一列，当前列设为下一列；
 * 
 * 若当前行是最后一行，当前列是最后一列，回溯，即清空当前行及以下各行的棋盘，然后，当前行设为上一行，当前列设为当前行的下一个待测位置；
 * 
 * 以上返回到第2步
 * 
 * 4) 在当前位置上不满足条件的情形：
 * 
 * 若当前列不是最后一列，当前列设为下一列，返回到第2步;
 * 
 * 若当前列是最后一列了，回溯，即，若当前行已经是第一行了，算法退出，否则，清空当前行及以下各行的棋盘，然后，当前行设为上一行，
 * 当前列设为当前行的下一个待测位置，返回到第2步;
 * 
 * @author cassie9082
 * 
 */
public class NQueens {
	public List<String[]> solveNQueens(int n) {
		
	}
}
