package first;

public class swapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null && head.next != null){
            ListNode next = head.next;
            ListNode nextnext = head.next.next;
            
            prev.next = next;
            next.next = head;
            head.next = nextnext;//will be a memory limit error w/o this line
            
            prev = head;
            head = nextnext;
            
        }
        
        return dummy.next;
        
    }

}
