package first;

public class reverseLinkedList2 {
	public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode prev = null;
        ListNode curt = head;
        
        while (curt != null) {
            ListNode next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        return prev;
    }

}
