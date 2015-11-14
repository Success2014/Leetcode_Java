package first;

public class reverseLinkedListII2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        int count = 1;
        while (count < m) {
            head = head.next;
            count++;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        
        ListNode prev = null;
        ListNode curt = mNode;
        while (count <= n) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
            count++;
        }
        prevM.next = prev;
        mNode.next = curt;
        
        return dummy.next;
    }

}
