package hot;

import java.util.HashMap;
import java.util.Map;

public class P146_LRU缓存 {
    class LRUCache {
        int capacity;
        DoubleList cache;
        Map<Integer, Node> map;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new DoubleList();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.get(key) != null) {
                Node x = map.get(key);
                cache.remove(x);
                cache.addLast(x);
                return x.value;
            }else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                Node x = map.get(key);
                cache.remove(x);
                map.remove(key);
                cache.addLast(node);
                map.put(key, node);
                return;
            }

            if (cache.size() == capacity) {
                Node first = cache.removeFirst();
                map.remove(first.key);
            }

            map.put(key, node);
            cache.addLast(node);
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        Node head;
        Node tail;
        int size;

        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public Node removeFirst() {
            Node first = head.next;
            remove(first);
            return first;
        }

        public void remove(Node x) {
            if (head.next == tail) {
                return;
            }
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public int size(){
            return size;
        }
    }
}
