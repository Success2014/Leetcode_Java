package first;

public class partitionList {
	public ListNode partition(ListNode head, int x) {
        if (head == null){
            return head;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftDummy = left;
        ListNode rightDummy = right;
        
        while (head != null){
            if (head.val < x){
                left.next = head;
                left = left.next;
            }
            else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }

}
