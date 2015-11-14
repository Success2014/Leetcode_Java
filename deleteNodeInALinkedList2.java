package first;

public class deleteNodeInALinkedList2 {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
