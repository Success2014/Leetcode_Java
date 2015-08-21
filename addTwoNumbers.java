package first;

public class addTwoNumbers {
	public ListNode addTwoNumbersM(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null){
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            
            int digit = carry + a + b;
            
            int val = digit % 10;
            carry = digit / 10;
            
            ListNode newNode = new ListNode(val);
            p.next = newNode;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            p = p.next;
            
        }
        if (carry == 1){
            p.next = new ListNode(1);
        }
        return dummy.next;
    }

}


