package first;

public class mergeKSortedLinkedLists3 {
	public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return lists[0];
        }
        while (n > 1) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                lists[start] = mergeTwoLists(lists[start], lists[end]);
                start++;
                end--;
            }
            n = (n + 1) / 2;
        }
        return lists[0];
        
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }
            else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l1 !=null){
            head.next = l1;
        }
        if (l2 != null){
            head.next = l2;
        }
        
        return dummy.next;
    }

}
