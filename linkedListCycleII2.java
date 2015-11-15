package first;

public class linkedListCycleII2 {
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                flag = true;
                break;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        if (!flag) {
            return null;
        }
        slow = head;
        while (slow != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
