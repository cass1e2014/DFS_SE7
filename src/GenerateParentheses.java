import java.util.ArrayList;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * 好了，我们已经征服了dfs的基础题，那么从数字的组合扩展到放置括号，我们只要分析什么情况下括号的组合是合法的即可
 * 1. 如果左括号数还没有用完，那么我们能继续放置左括号
 * 2. 如果已经放置的左括号数大于已经放置的右括号数，那么我们可以放置右括号 
 *   （如果放置的右括号数大于放置的左括号数，会出现不合法组合）
 * 所以，运用dfs在每一层递归中，如果满足条件先放置左括号，如果满足条件再放置右括号
 * 程序有两种书写习惯，
 * 第一种，像之前的程序一样，我们把String tmp写在dfs里面，每回Return删去刚刚添加的字符
 * 第二种，直接把tmp ＋（添加的字符）当参数传入下一层调用函数，这样返回后在上一层是之前传入的参数，不用删字符
 */

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		ArrayList<String> res = gp.generateParenthese(2);
		for (String s : res) {
			System.out.println("GenerateParentheses -- main(): " + s);
		}
	}

	public ArrayList<String> generateParenthese(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n < 0) {
			return result;
		}

		getPair(result, "", n, n);
		return result;
	}

	public void getPair(ArrayList<String> result, String s, int left, int right) {
		if (left > right || left < 0 || right < 0) {
			return;
		}

		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}
		getPair(result, s + "(", left - 1, right);
		getPair(result, s + ")", left, right - 1);
	}
}
