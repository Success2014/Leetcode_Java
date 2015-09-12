package first;

public class reverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
