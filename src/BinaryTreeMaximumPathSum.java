/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 		1
 * 	   /  \
 *    2    3
 * Return 6.
 * 
 * Time: o(n)
 * Space: o(logn)
 * Bottom-up
 * 
 * 用maxSum记录最大的path长度，在每个节点求得其左子树和右子树的maxPath = left and rigth，
 * 若为正则和该node的val一起相加，在与maxSum比较:maxSum = max{x.val + left + right, maxSum};
 * 
 * 递归函数则返回左右子树最大的一侧path，再加上该node的val：
 * ret = x.val + max{left, right};
 * 如果ret为负，则返回0。
 * 
 * @author cassie9082
 * 
 */

// maxSum: store the max at current node
// ret: store the max from current node to its one side, used to calculate its parent's maxSum 

public class BinaryTreeMaximumPathSum {
	public class Solution {
		private int maxSum; //global value

		public int maxPathSum(TreeNode root) {
			maxSum = Integer.MIN_VALUE;
			findMax(root);
			return maxSum;
		}

		private int findMax(TreeNode node) {
			if (node == null) {
				return 0;
			}

			int left = findMax(node.left);
			int right = findMax(node.right);
			maxSum = Math.max(node.val + left + right, maxSum);
			int retVal = node.val + Math.max(left, right);
			return retVal > 0 ? retVal : 0;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
