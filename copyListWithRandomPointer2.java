package first;

public class copyListWithRandomPointer2 {
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode next = temp.next;
            RandomListNode copy = new RandomListNode(temp.label);
            temp.next = copy;
            copy.next = next;
            temp = next;
        }
        
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        RandomListNode p1 = head;
        RandomListNode p2 = head.next;
        RandomListNode p2dummy = p2;
        while (p2.next != null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
        return p2dummy;
    }
}
