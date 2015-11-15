package first;

public class sortList2 {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        return mergeTwoLists(left, right);
    }
    
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                head.next = p1;
                p1 = p1.next;
            } else {
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }
        if (p1 != null) {
            head.next = p1;
        }
        if (p2 != null) {
            head.next = p2;
        }
        return dummy.next;
    }

}
