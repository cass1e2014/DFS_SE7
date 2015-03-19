import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author cassie9082
 *
 */

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//临界情况
		if(n <= 0 || k < 0){
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		combinationHelper(result, list, n, k, 1); //start with 1(n = 1...4)
		return result;
	}
	
	public void combinationHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int n, int k, int pos){
		if(list.size() == k){
			result.add(new ArrayList(list));
			return;
		}
		
		for(int i = pos; i <= n; i++){
			list.add(i);
			combinationHelper(result, list, n, k, i + 1);
			list.remove(list.size() - 1);//移掉在list中的最后一位
		}
	}
	
	public static void main(String[] args){
		Combinations cb = new Combinations();
		System.out.println(cb.combine(4, 2));
		
	}
}
