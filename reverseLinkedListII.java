package first;

public class reverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m > n){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode premNode = dummy;
        int count = 1;
        
        while (count < m){
            premNode = head;
            head = head.next;
            count++;
        }
        ListNode mNode = head;
        
        ListNode prev = null;
        while (count <= n){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            count++;
        }
        
        premNode.next = prev;//prev is nNode
        mNode.next = head;//head is postnNode 
        
        return dummy.next;
   }
	
	public static void main (String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		reverseLinkedListII rl = new reverseLinkedListII();
		ListNode res = rl.reverseBetween(node1, 1, 2);
		System.out.println(res.val);
		
	}

}
