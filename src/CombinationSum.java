import java.util.ArrayList;
import java.util.Arrays;

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

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSumHelper(result, list, candidates, target, 0);
		return result;
	}

	public void combinationSumHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int[] candidates, int target, int pos) {
		if (target < 0) {
			return;
		}
		// 什么时候返回？
		if (target == 0) {
			result.add(new ArrayList(list));
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			// for循环中第一步有一个判断，那个是为了去除重复元素产生重复结果的影响，因为在这里每个数可以重复使用，所以重复的元素也就没有作用了
			if (i != pos && candidates[i] == candidates[i - 1]) {
				continue;
			}
			list.add(candidates[i]);
			combinationSumHelper(result, list, candidates, target
					- candidates[i], i);// 此处不是i＋1！因为The same repeated number
										// may be chosen unlimited number of
										// times.
			list.remove(list.size() - 1);
		}

	}

}
