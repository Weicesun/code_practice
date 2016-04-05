public class LRUCache {
    public class Node {
        public Node pre;
        public Node next;
        int val;
        int key;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.pre = null;
        head.next = tail.pre;
        tail.pre = head;
        tail.next = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node res = map.get(key);
            res.pre.next = res.next;
            res.next.pre = res.pre;
            moveTail(res);
            return res.val;
        }
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        Node n = new Node(key, value);
        map.put(key, n);
        moveTail(n);
    }
    public void moveTail(Node n) {
        
        n.pre = tail.pre;
        tail.pre = n;
        n.pre.next = n;
        n.next = tail;
        
    }
}
