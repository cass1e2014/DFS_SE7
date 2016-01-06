import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * For example:
 * 
 * Given s = "aabb", return ["abba", "baab"].
 * 
 * Given s = "abc", return [].
 * 
 * @author cassie9082
 * 
 */
public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<String>();//用来装左半部分的permutation
        if(s == null || s.length() == 0)    return result;
        
        //1. determine if the string s is palindrome permutated
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        if(!isPalindromePermutation(s, map))    return result;//先用字母的出现个数下去判断是否有可能做permutation
        
        //2. form the left half of the seed string
        StringBuffer sb = new StringBuffer();
        char middle = '\0';
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            int val = (int)pair.getValue();
            char key = (char)pair.getKey();
            while(val > 1){
                sb.append(key);
                val -= 2;
            }
            
            if(val == 1){
                middle = key;
            }
        }
        
        //3. generate the permutations of the string
        permutation(sb.toString().toCharArray(), 0, result);//这里的permutation基本就是做swap
        List<String> result2 = new ArrayList<String>();//装整个permutation，也是最后要返回的result
        
        //4. append the right half of the string
        for(String str : result){
            StringBuffer tmp = new StringBuffer(str);
            if(middle != '\0'){
                tmp.append(middle);
            }
            for(int i = str.length() - 1; i >= 0; i--){
                tmp.append(str.charAt(i));
            }
            result2.add(tmp.toString());
        }
        return result2;
    }
    
    private boolean isPalindromePermutation(String s, Map<Character, Integer> map){
        int tolerance = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        
        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry pair = (Map.Entry)itr.next();
            int val = (int)pair.getValue();
            if(val % 2 == 1)    tolerance ++;
        }
        
        if(tolerance <= 1){
            return true;
        }else{
            return false;
        }
    }
    
    private void permutation(char[] s, int start, List<String> result){
        if(start >= s.length){
            result.add(new String(s));
            return;
        }
        
        for(int i = start; i < s.length; i++){
            if(!containsDuplicate(s, start, i)){
                swap(s, i, start);
                permutation(s, start + 1, result);
                swap(s, i, start);
            }
        }
    }
    
    private boolean containsDuplicate(char[] s, int start, int end){
        for(int i = start; i < end; i++){
            if(s[start] == s[end]){
                return true;
            }
        }
        return false;
    }
    
    private void swap(char[] s, int i , int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
