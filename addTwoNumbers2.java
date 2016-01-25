package first;


public class addTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            int val = (carry + a + b) % 10;
            carry = (carry + a + b) / 10;
            
            ListNode nd = new ListNode(val);
            p.next = nd;
            
            
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            p = p.next;
        }
        
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
        
    }

}
