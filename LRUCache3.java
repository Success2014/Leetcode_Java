package first;
import java.util.*;
public class LRUCache3 {
	class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-2, -2);
    int capacity;
    public LRUCache3(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node curt = map.get(key);
            res = curt.value;
            curt.prev.next = curt.next;
            curt.next.prev = curt.prev;
            moveToTail(curt);
        }
        return res;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            Node curt = map.get(key);
            curt.value = value;
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
            map.put(key, newNode);
            moveToTail(newNode);
        }
    }
    public void moveToTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        node.prev = prev;
        tail.prev = node;
    }

}
