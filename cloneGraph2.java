package first;
import java.util.*;
public class cloneGraph2 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode nd = queue.poll();
            UndirectedGraphNode copy;
            if (map.containsKey(nd)) {
                copy = map.get(nd);
            } else {
                copy = new UndirectedGraphNode(nd.label);
                map.put(nd, copy);
            }
            
            for (UndirectedGraphNode nb: nd.neighbors) {
                if (!map.containsKey(nb)) {
                    UndirectedGraphNode nbCopy = new UndirectedGraphNode(nb.label);
                    queue.offer(nb);
                    map.put(nb, nbCopy);
                }
                copy.neighbors.add(map.get(nb));
            }
        }
        return map.get(node);
    }

}
