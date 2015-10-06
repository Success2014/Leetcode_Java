package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.List;

public class cloneGraph {
	public UndirectedGraphNode cloneGraphM(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, newHead);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode nd = queue.poll(); 
            UndirectedGraphNode nd_copy = map.get(nd);
            
            for (UndirectedGraphNode nb: nd.neighbors){
            	UndirectedGraphNode nb_copy;
                if (map.containsKey(nb)){
                    nb_copy = map.get(nb);
                }
                else{
                    nb_copy = new UndirectedGraphNode(nb.label);
                    map.put(nb, nb_copy);
                    queue.add(nb);
                }
                nd_copy.neighbors.add(nb_copy);
            }
            
        }
        
        return newHead;
    }

}


class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x)	{ 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
	
};