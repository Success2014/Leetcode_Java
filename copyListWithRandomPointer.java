package first;
import java.util.Map;
import java.util.HashMap;

public class copyListWithRandomPointer {
	
	/**
	 * Method 1, use a hashmap to store the mapping between original node and the copied node.
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode p = head;
        RandomListNode q = dummy;
        while (p != null){
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummy;
        while (p != null){
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
        
    }
	/**
	 * method 2: make a copy of each node first, then assign the random pointer, then split into two lists
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;
        RandomListNode p = head;
        //make copies
        while (p != null){
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }
        
        //connect random pointers
        p = head;
        while (p != null){
            p.next.random = (p.random != null)?p.random.next:null;
            p = p.next.next;
        }
        
        //split into to lists
        RandomListNode headCopy = head.next;
        RandomListNode pold = head;
        RandomListNode pnew = headCopy;
        while (pnew.next != null){
            pold.next = pnew.next;
            pold = pold.next;
            pnew.next = pold.next;
            pnew = pnew.next;
        }
        pold.next = null;
        
        return headCopy;
        
    }

}


class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};