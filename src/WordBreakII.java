import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word. Return all such
 * possible sentences. 
 * For example, given s = "catsanddog", 
 * 					dict = ["cat", "cats", "and", "sand", "dog"]. 
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    //If we partitioned the string into two substring recursively 
    //The time complexity would be O(2^N)
    //The test case can't pass would be : the case containing very long string which is NOT breakable
    //so need to check if the string is breakable first, if not, no need to do the following computations
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0 || wordDict.isEmpty())  return result;
        wordBreakHelper(s, wordDict, "", result);
        return result;
    }
    
    public void wordBreakHelper(String s, Set<String> wordDict, String item, List<String> result){
        if(!isBreakable(s, wordDict))   return;
        if(s.length() == 0){
            result.add(item);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(wordDict.contains(sb.toString())){
                String newItem = item.length() > 0 ? item + " " + sb.toString() : sb.toString();
                wordBreakHelper(s.substring(i + 1), wordDict, newItem, result);
            }
        }
    }
    
    public boolean isBreakable(String s, Set<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
