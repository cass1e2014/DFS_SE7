import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations. For example,
 * [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2], and [3,2,1].
 * 
 * @author cassie9082
 * 
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] num = {1, 2, 3};
		System.out.println(p.permute(num));

	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null)    return result;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        permuteHelper(result, list, nums);
        return result;
    }
    
    public void permuteHelper(List<List<Integer>> result, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
        	//重要，必须要有的条件
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            permuteHelper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
