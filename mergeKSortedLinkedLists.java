package first;
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;

public class mergeKSortedLinkedLists {
	/**
	 * Method 1, use heap to get the minimum
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        for (ListNode node: lists){
            if (node != null) queue.add(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) queue.add(node.next);
        }
        return dummy.next;
    }
	
	
	
	/**
	 * Method 2, merge two lists each time and save the new head to the start.
	 * Use two while loops. In the first while loop, the linked list effectively reduced by half.
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        int end = lists.length - 1;
        while (end > 0){ // could write in other ways, see the second trial of this questions
            int begin = 0;
            while (begin < end){
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                p.next = l2;
                l2 = l2.next;
            }
            else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 == null){
            p.next = l2;
        }
        if (l2 == null){
            p.next = l1;
        }
        return dummy.next;
    }
	
	/**
	 * Method 3, divide and conquer.
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }
    
    public ListNode helper(ListNode[] lists, int start, int end){
        if (start == end){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }   

}


class ListNodeComparator implements Comparator<ListNode>{
	@Override
	public int compare (ListNode x, ListNode y){
		return Integer.compare(x.val, y.val);
		//return x.val - y.val; // this also works
	}
}