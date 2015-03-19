import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.

Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.

For example, If S = [1,2,3], a solution is: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * @author cassie9082
 *
 */
public class SubSets {
	public ArrayList<ArrayList<Integer>> subsets(int[] num){
		if (num == null || num.length == 0){
			return null;
		}
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		subsetsHelper(result, list, num, 0);
		return result;
		
	}
	
	public void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int pos){
		result.add(new ArrayList<Integer>(list));
		for(int i = pos ; i < num.length; i++){
			list.add(num[i]);
			subsetsHelper(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args){
		int[] num = { 1, 2, 3};
		SubSets ss = new SubSets();
		ArrayList<ArrayList<Integer>> res = ss.subsets(num);
		for(ArrayList<Integer> list : res ){
			System.out.print("(");
			for(Integer i : list){
				System.out.print(" " + i + " ");
			}
			System.out.print(")");
		}	
	}
}
