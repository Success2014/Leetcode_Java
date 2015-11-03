package first;

import java.util.HashMap;

public class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1); // dummy head
    private Node tail = new Node(-1, -1); // dummy tail
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // remove curt
        Node curt = map.get(key);
        curt.prev.next = curt.next;
        curt.next.prev = curt.prev;
        // move curt to the tail
        moveToTail(curt);
        
        return map.get(key).val;
    }
    
    public void set(int key, int value) {
        Node newNode = new Node(key, value);
        /*if (map.containsKey(key)) {
            map.put(key, newNode);
            return;
        }*/ // this wrong, newNode doesn't have prev, next info
        if(get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        if (map.size() == capacity) { // remove a node first
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        map.put(key, newNode);
        moveToTail(newNode);
    }
    
    public void moveToTail(Node curt) {
        curt.prev = tail.prev;
        tail.prev = curt;
        curt.prev.next = curt;
        curt.next = tail;
        
    }
    
    public static void main(String[] args) {
    	LRUCache lru = new LRUCache(2);
    	lru.set(2, 1);
    	lru.set(2, 2);
    	System.out.println(lru.get(2));
    	lru.set(1, 1);
    	lru.set(4, 1);
    	System.out.println(lru.get(4));
    }
}