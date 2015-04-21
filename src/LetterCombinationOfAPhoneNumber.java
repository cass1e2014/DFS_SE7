import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Letter Combinations of a Phone Number Total Accepted:
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */

public class LetterCombinationOfAPhoneNumber {
	/*
	 * 1. 数字1所对应的是空集，不要忘了 
	 * 2. tmp直接添加字符传入递归参数，这样返回后不用截取tmp
	 */
	public static void main(String[] args) {
		String s = "23";
		LetterCombinationOfAPhoneNumber phoneNumber = new LetterCombinationOfAPhoneNumber();
		List<String> res = phoneNumber.letterCombinations(s);
		for (String a : res) {
			System.out.println(a);
		}		;
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();

		if (digits == null) {
			return result;
		}

		Map<Character, char[]> map = new HashMap<Character, char[]>();
		map.put('0', new char[] {});
		map.put('1', new char[] {});
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });

		StringBuilder sb = new StringBuilder();
		helper(map, digits, sb, result);

		return result;
	}

	private void helper(Map<Character, char[]> map, String digits,
			StringBuilder sb, List<String> result) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}

		for (char c : map.get(digits.charAt(sb.length()))) {
			sb.append(c);
//			System.out.println("1: " + sb);
			helper(map, digits, sb, result);
			sb.deleteCharAt(sb.length() - 1);
//			System.out.println("2: " + sb);
		}
	}

}
