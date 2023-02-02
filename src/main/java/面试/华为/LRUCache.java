package 面试.华为;

import java.util.HashMap;

/**
 * 实现一个LRU（最近最少使用）缓存，在初始化时指定最大容量，当缓存容量达到上限时，删除最近最少使用的数据，为新添加的数据腾出空间。
 * 实现LRUCache类：
 * LRUCache(int capacity) capacity为缓存容量上限
 * void put(int key, int value) 如果key不存在，则插入数据，如果缓存容量达到上限，则在插入之前删除最近最少使用的数据；如果key已经存在，则使用新的value覆盖原来的值。
 * int get(int key) 使用key（关键字）从缓存中获取值，获取成功后表明数据被使用；获取失败则返回-1
 * <p>
 * 3.2.1.2.	样例
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 1);    // 1添加进缓存
 * cache.put(2, 2);    // 2添加进缓存
 * cache.get(1);       // 返回1，1使用过一次
 * cache.put(3, 3);    // 3添加进缓存，2被挤出缓存，2为最近最少使用的数据
 * cache.get(1);       // 返回 1
 * cache.get(2);       // 返回 -1，2已被挤出缓存
 * cache.get(3);       // 返回 3
 */
public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (capacity == cache.size) {
            removeLeast();
        }
        addRecently(key, value);
    }
    private void removeLeast() {
        Node x = cache.removeFirst();
        int deleteKey = x.key;
        map.remove(deleteKey);
    }
    private void addRecently(int key, int value) {
        Node node = new Node(key, value);
        cache.addLast(node);
        map.put(key, node);
    }
    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).value;
    }
    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
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
    int size;
    Node head;
    Node tail;
    public DoubleList() {
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
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    public int size() {
        return size;
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);    // 1添加进缓存
        cache.put(2, 2);    // 2添加进缓存
        System.out.println(cache.get(1));       // 返回1，1使用过一次
        cache.put(3, 3);    // 3添加进缓存，2被挤出缓存，2为最近最少使用的数据
        System.out.println(cache.get(1));       // 返回 1
        System.out.println(cache.get(2));       // 返回 -1，2已被挤出缓存
        System.out.println(cache.get(3));       // 返回 3
    }


}
