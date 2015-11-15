package first;
import java.util.*;
public class mergeKSortedLinkedLists2 {
	/**
	 * Method 1: merge two each time.
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return lists[0];
        }
        while (n > 1) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                lists[start] = mergeTwoLists(lists[start], lists[end]);
                start++;
                end--;
            }
            n = (n + 1) / 2;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }
    
    /**
     * Use heap
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(n, new ListNodeComparator());
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode curt = pq.poll();
            head.next = curt;
            if (curt.next != null) {
                pq.offer(curt.next);
            }
            head = head.next;
        }
        return dummy.next;
    }

}
