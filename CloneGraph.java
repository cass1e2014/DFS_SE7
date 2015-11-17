import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 *     1
      / \
     /   \
    0 --- 2
         / \
         \_/
 * @author cassie9082
 * 
 */
public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	/*
	 * 这道题考察对图的遍历和利用HashMap拷贝的方法。
	 * 对图的遍历就是两个经典的方法DFS和BFS。BFS经常用Queue实现，DFS经常用递归实现（可改为栈实现）。
	 * 拷贝方法是用用HashMap，key存原始值，value存copy的值，用DFS,BFS方法遍历帮助拷贝neighbors的值。
	 */

	// BFS：这个就是相对于BFS的另外一种对图的遍历方法，对于一个节点来说先把所有neighbors都检查一遍，再从第一个neighbor开始，循环往复。
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)    return node;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);//hashmap里放的是原node和对应的复制的node
        queue.add(node);//还未检查过neighbor的原来node放到queue里
        while(!queue.isEmpty()){
            UndirectedGraphNode currentNode = queue.poll();
            for(UndirectedGraphNode neighbor : currentNode.neighbors){
                if(!hm.containsKey(neighbor)){
                    queue.add(neighbor);
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);//复制
                    hm.put(neighbor,newNeighbor);
                }
                hm.get(currentNode).neighbors.add(hm.get(neighbor));//把复制的新neighbor加到复制的currentNode的neighbor list中去
            }
        }
        return head;
    }

	// DFS：就是深度搜索，一条路走到黑，再选新的路。 （DFS递归法）
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}

		HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		hm.put(node, head);
		dfs(hm, node);
		return head;
	}

	public void dfs(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm,
			UndirectedGraphNode node) {
		if(node == null){
			return;
		}
		
		for(UndirectedGraphNode neighbor : node.neighbors){
			if(!hm.containsKey(neighbor)){
				UndirectedGraphNode newNeighbor = new UndirectedGraphNode(node.label);
				hm.put(neighbor, newNeighbor);
				dfs(hm, newNeighbor);
			}
			hm.get(node).neighbors.add(hm.get(neighbor));//加到visit过的neighbor的list里面去
		}
	}

}
