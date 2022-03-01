package design;

import java.util.HashMap;
import java.util.Map;

class DLinkNode {
    DLinkNode pre;
    DLinkNode next;
    int key;
    int value;

    public DLinkNode() {
    }

    public DLinkNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


class LRUCache {

    int size;
    int capacity;
    DLinkNode head;
    DLinkNode tail;
    Map<Integer, DLinkNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node == null) {
            node = new DLinkNode(key, value);
            map.put(key, node);
            addToHead(node);
            ++size;
            if (size > capacity) {
                DLinkNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
