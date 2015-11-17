package first;
import java.util.*;
public class LRUCache2 {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-2, -2);
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node curt = map.get(key);
        curt.prev.next = curt.next;
        curt.next.prev = curt.prev;
        moveToTail(curt);
        return curt.val;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        } else {
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                Node lruNode = head.next;
                map.remove(lruNode.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
            map.put(key, newNode);
            moveToTail(newNode);
        }
    }
    
    public void moveToTail(Node curt) {
        curt.prev = tail.prev;
        curt.next = tail;
        curt.prev.next = curt;
        curt.next.prev = curt;
        /*curt.prev = tail.prev;
        tail.prev = curt;
        curt.prev.next = curt;
        curt.next = tail;*/
    }
}
class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}