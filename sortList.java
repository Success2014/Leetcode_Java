package first;

public class sortList {
	public ListNode sortListM(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode rightHead = sortListM(mid.next);
        mid.next = null;
        ListNode leftHead = sortListM(head);
        ListNode newHead = merge(leftHead, rightHead);
        return newHead;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                newHead.next = head1;
                head1 = head1.next;
            }
            else{
                newHead.next = head2;
                head2 = head2.next;
            }
            newHead = newHead.next;
        }
        
        if (head1 != null){
            newHead.next = head1;
        }
        if (head2 != null){
            newHead.next = head2;
        }
        return dummy.next;
    }

}
