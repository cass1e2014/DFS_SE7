import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * [ 
 * 	["aa","b"], 
 * 	["a","a","b"] 
 * ]
 * 
 * @author cassie9082
 * 
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		if(s == null){
			return result;
		}
		helper(result, list, s, 0);
		return result;
	}
	
	public void helper(List<List<String>> result, List<String> list, String s, int pos){
		if(pos == s.length()){
			result.add(new ArrayList<String>(list));
			return;
		}
		
		for(int i = pos + 1; i <= s.length(); i ++){
			String prefix = s.substring(pos, i);
			if(!isPalindrome(prefix)){
				continue;
			}
			
			list.add(prefix);
			helper(result, list, s, i);
			list.remove(list.size() - 1);
		}
	}
	
	public boolean isPalindrome(String s){
		int start = 0;
		int end = s.length() - 1;
		while(start < end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start ++;
			end --;
		}
		return true;
	}
}
