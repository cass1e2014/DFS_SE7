import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 * 
 * @author cassie9082
 * 
 */
public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(cs.combinationSum(candidates, target));

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null)  return result;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(result, list, target, candidates, 0);
        return result;
    }
    
    public void combinationSumHelper(List<List<Integer>> result, List<Integer> list, int target, int[] candidates, int pos){
        if(target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(target < 0){
            return;
        }
        
        for(int i = pos; i < candidates.length; i++){
        	//211, [211]和[211]这种情况
            if(i != pos && candidates[i] == candidates[i - 1]){
                continue;
            }
            
            list.add(candidates[i]);
            combinationSumHelper(result, list, target - candidates[i], candidates, i);//i 元素可以被用多于一次
            list.remove(list.size() - 1);
        }
    }
}
