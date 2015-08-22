package first;
/**
 * https://leetcode.com/discuss/32586/non-recursive-java-solution-and-idea
 * 
     * Reverse a link list between begin and end exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |   
     * begin       end
     * after call begin = reverse(begin, end)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *      begin end
     * @return the reversed list's 'begin' node, which is the precedence of node end
     
 * https://leetcode.com/discuss/21301/short-but-recursive-java-code-with-comments
 * https://leetcode.com/discuss/17483/share-my-java-solution-with-comments-in-line
 * @author Neo
 *
 */
public class reverseNodesInKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode begin = dummy;
		
		int c = 0; // counter
		while (head != null){
			c++;
			if (c % k ==0){
				begin = reverse(begin, head.next);
				head = begin.next;
			}
			else{
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	/**
	 * Reverse the nodes between begin and end, not including begin and end.
	 * Every loop you only do one thing: reverse one node.
	 * @param begin
	 * @param end
	 * @return first, which is originally the head, but now is the tail.
	 */
	public ListNode reverse(ListNode begin, ListNode end){
		ListNode cur = begin.next;
		ListNode first = cur; // from this node to reverse, after reverse, it will be the last node.
		ListNode prev = begin;
		
		while (cur != end){
			ListNode next = cur.next;
			cur.next = prev;
			
			prev = cur;
			cur = next;			
		}
		begin.next = prev;
		first.next = end; // or first.next = cur;
		return first;
		
	}
	
	public static void main(String[] args){
		reverseNodesInKGroup rnik = new reverseNodesInKGroup();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode newhead = rnik.reverseKGroup(node1, 2);
		System.out.println(newhead.val);
	}

}
