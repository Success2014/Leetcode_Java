package first;

public class reorderList2 {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode newHead = reverseList(midNext);
        
        while (head != null && newHead != null) {
            ListNode next = head.next;
            ListNode newNext = newHead.next;
            head.next = newHead;
            newHead.next = next;
            head = next;
            newHead = newNext;
        }
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
