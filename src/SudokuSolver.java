/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * 首先这道题的思路的比较直观，我们先把空着的格子统计出来放到一个ArrayList<int> 里面, 然后开始运用dfs
 * 首先每当填入一个数字的时候我们需要用isValid来验证，只有不冲突的情况下才能添加进格子里
 * dfs 函数返回值定义为boolean 
 * if(dfs(empty,board,cur+1,len))运行成功往上一层返回true，如果不成功, 把刚填入的数字抹去再去试下一个数字，
 * 如果这一层的数字都不成功，返回false, 跳回上一层进行修改，最后如果cur==len 的时候所有格子都填完返回true，一路返回true上去完成任务
 * 几点注意的地方： 
 * 1. 验证小九宫格的时候，坐标为｛3*(row/3)+i/3 , 3*(col/3)+i%3｝
 * 2. char到int的转换 - '0'
 */

public class SudokuSolver {
	public void solveSudoku(char[][] board) {

	}
}
