import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 * 
 * @author cassie9082
 * 
 */
public class PermutationsII {

	public static void main(String[] args) {
		PermutationsII p2 = new PermutationsII();
		int[] num = { 1, 1, 2 };
		System.out.println(p2.permuteUnique(num));

	}

	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		List<Integer> list = new ArrayList<Integer>();

		int[] visited = new int[num.length];

		Arrays.sort(num);
		permuteUniqueHelper(result, list, num, visited);
		return result;
	}

	public void permuteUniqueHelper(List<List<Integer>> result,
			List<Integer> list, int[] num, int[] visited) {
		if (list.size() == num.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			System.out.println("in for loop, i = " + i);
			if (visited[i] == 1
					|| (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)) {
				System.out.println("in If, i = " + i);
				continue;
			}
			visited[i] = 1;
			list.add(num[i]);
			System.out.println("list.add : " + num[i]);
			permuteUniqueHelper(result, list, num, visited);
			visited[i] = 0;
			System.out.println("list.remove : " + num[i]);
			list.remove(list.size() - 1);
		}
	}

}
