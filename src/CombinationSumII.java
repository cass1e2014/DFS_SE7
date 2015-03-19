import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author cassie9082
 * 
 */
public class CombinationSumII {

	public static void main(String[] args) {
		CombinationSumII csII = new CombinationSumII();
		int[] num = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		System.out.println(csII.combinationSum2(num, target));
	}

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		combinationSum2Helper(result, list, num, target, 0);
		return result;
	}

	public void combinationSum2Helper(List<List<Integer>> result,
			List<Integer> list, int[] num, int target, int pos) {
		if(target < 0){
			return;
		}
		
		if(target == 0){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i = pos; i < num.length; i++){
			if(i != pos && num[i] == num[i - 1]){
				continue;
			}
			list.add(num[i]);
			combinationSum2Helper(result, list, num, target - num[i], i + 1);//注意！此时传到下一层的pos是i+1(Each number in C may only be used once in the combination.)
			list.remove(list.size() - 1);
		}
	}

}
