class LRUCache {

    private int cache_cap;
    private HashMap<Integer, Node> cache;
    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache(int capacity) {
        cache_cap = capacity;
        cache = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(cache.size() == cache_cap) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node();
            node.key = key;
            node.val = value;

            cache.put(key, node);
            add(node);
        }
    }

    public void add(Node node) {
        Node head_next = head.next;
        node.next = head_next;
        head_next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;

        prev_node.next = next_node;
        next_node.prev = prev_node;
    }
}

public class Node {
    int key;
    int val;
    Node prev;
    Node next;
}
