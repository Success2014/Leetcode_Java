package first;

public class reorderList {
	public void reorderListM(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode tail = reverse(midNext);
        merge(head, tail);
        
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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    public void merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        boolean flag = true;
        while (head1 != null && head2 != null){
            if (flag == true){
                dummy.next = head1;
                flag = false;
                head1 = head1.next;
            }
            else{
                dummy.next = head2;
                flag = true;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        if (head1 != null){
            dummy.next = head1;
        }
        if (head2 != null){
            dummy.next = head2;
        }
        
    }

}
