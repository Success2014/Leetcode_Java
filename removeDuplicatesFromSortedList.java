package first;

public class removeDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode node = head;
        while (node != null && node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }
        }
        return head;
    }

}
