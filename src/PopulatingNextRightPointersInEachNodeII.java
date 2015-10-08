/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
 同I不同的是，root.right.next 不一定等于 root.next.left
 目标是先确定root的右孩子的第一个有效next的连接点，然后再处理左孩子   
 
 * @author cassie9082
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        TreeLinkNode p = root.next;
        
        while(p != null){
            if(p.left != null){
                p = p.left;
                break;
            }
            if(p.right != null){
                p = p.right;
                break;
            }
            p = p.next;
        }
        
        if(root.right != null){
            root.right.next = p;
        }
        
        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
            }else{
                root.left.next = p;
            }
        }
        
        connect(root.right); //先做右边再做左边
        connect(root.left);
    }
}
