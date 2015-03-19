import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets. 
 * Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets. 
 * For example, If S = [1,2,2], a solution is: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * @author cassie9082
 *
 */
public class SubSetsII {

	public static void main(String[] args) {
		int[] num = { 2, 3, 3};
		SubSetsII ss = new SubSetsII();
		ArrayList<ArrayList<Integer>> res = ss.subsets(num);
		for(ArrayList<Integer> list : res ){
			System.out.print("(");
			for(Integer i : list){
				System.out.print(" " + i + " ");
			}
			System.out.print(")");
		}
	}
	
	
	public ArrayList<ArrayList<Integer>> subsets(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		subsetsHelper(result, list, num, 0);
		return result;
	}
	
	public void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int pos){
		result.add(new ArrayList<Integer>(list));
		
		for(int i = pos; i < num.length; i++){
			//在删去元素后，再取元素的时候，不要取和刚刚取过的元素相等的元素
			if(i != pos && num[i] == num[i - 1]){
				continue;
			}
			list.add(num[i]);
			subsetsHelper(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
