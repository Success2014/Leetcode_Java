package first;

public class mergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                p.next = l2;
                l2 = l2.next;
            }
            else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 == null){
            p.next = l2;
        }
        if (l2 == null){
            p.next = l1;
        }
        return dummy.next;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
