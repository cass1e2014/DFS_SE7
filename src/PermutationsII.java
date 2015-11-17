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
	
	//有重复
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null)    return result;
        List<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(result, list, nums, visited);
        return result;
    }
    
    public void permuteUniqueHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int[] visited){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1 || i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            permuteUniqueHelper(result, list, nums, visited);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
