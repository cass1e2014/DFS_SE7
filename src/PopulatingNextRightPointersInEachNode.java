/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    
是一棵perfect binary tree，所以所有的node都在same level，每一个parent都有2个小孩
如果当前节点有左孩子，那么左孩子的next指向右孩子，
如果当前节点有右孩子，那么如果root的旁边（next指针）有另一个node，
则当前节点的右孩子的next指向当前节点的next的左孩子
不然的话指向null    
    
 * @author cassie9082
 *
 */
public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root.right;
        }
        
        if(root.right != null){
            if(root.next != null){
                root.right.next = root.next.left;
            }else{
                root.right.next = null;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}

 class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}
