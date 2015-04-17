/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *  
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 * 
 * 这道题的思路就是对1..n中的每一个数都依次让它做root，然后分出左右区间，再递归求解。
 * 最后把左右区间求得的子结果依次分别作为root的左右孩子，因此总共要3次循环。
 * 还有值得注意的技巧是，当begin>end时，要往ret AL里面添加null，使得每个AL里面至少有一个元素（null）。
 * 这样可以避免判断只有左区间或只有右区间的情况。
 */
public class UniqueBinarySearchTreesII {
	public static ArrayList<TreeNode> generateTrees(int n) {

	}
}
