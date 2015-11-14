package first;

public class removeDuplicatesFromSortedListII2 {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null) {
            ListNode node = head.next;
            if (node != null && node.next != null && node.val == node.next.val) {
                while (node != null && node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                head.next = node.next;
                node = head.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
	
	public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int value = head.next.val;
                while (head.next != null && head.next.val == value) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

}
