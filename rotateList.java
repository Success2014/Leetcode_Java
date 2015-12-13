package first;

public class rotateList {
	/**
	 * 1) Get the length 2) Move to the (n-k%n)th node 3)Do the rotation
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // find the length of list
        int n = 0;
        while (fast.next != null) {
            fast = fast.next;
            n++;
        }
        
        // corner case
        k = k % n;
        if (k == 0) {
            return head;
        }
        
        // find the break point
        for (int j = n - k; j > 0; j--) {
            slow = slow.next;
        }
        
        // rotate the list
        fast.next = dummy.next;//last node connect to the head
        dummy.next = slow.next;//get new head
        slow.next = null;//end of the list
        
        return dummy.next;
    }
	/**
	 * First trail
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p = head;
        ListNode prev = dummy;
        int n = 0;
        while (p != null) {
            n++;
            prev = prev.next;
            p = p.next;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        prev.next = dummy.next;
        
        p = head;
        prev = dummy;
        int c = 0;
        while (c < n - k) {
            prev = prev.next;
            p = p.next;
            c++;
        }
        prev.next = null;
        dummy.next = p;
        return dummy.next;
    }
}
