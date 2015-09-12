package first;

public class removeDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null){
            if (head.next.val == head.next.next.val){
                int val = head.next.val;
                while (head.next != null && head.next.val == val){//loop on head.next!!!
                    head.next = head.next.next;
                }
            }
            else{
                head = head.next;
            }
        }
        return dummy.next;
    }

}
