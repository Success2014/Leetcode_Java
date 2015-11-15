package first;

public class partitionList2 {
	public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        
        head1.next = dummy2.next;
        head2.next = null;
        return dummy1.next;
    }
	public static void main(String[] args) {
		partitionList2 pl = new partitionList2();
		ListNode nd1 = new ListNode(1);
		ListNode nd2 = new ListNode(2);		
		nd2.next = nd1;
		System.out.println(pl.partition(nd2, 2));
	}

}
