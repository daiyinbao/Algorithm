package DoubleLinkedList;

import java.util.Iterator;

public class DoubleLinkedList_ implements Iterable<Integer> {

    static class Node {
        Node pre;
        Node next;
        int value;

        public Node(Node pre, Node next, int value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }

    private Node head;//头哨兵
    private Node tail;//尾哨兵

    public DoubleLinkedList_() {
        head = new Node(null, null, 666);
        tail = new Node(null, null, 888);
        head.next = tail;
        tail.pre = head;
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }

        }
        return null;
    }

    public void addIndex(int index, int value) {
        Node preNode = findNode(index - 1);
        if (preNode == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        Node nextNode = preNode.next;
        Node insert = new Node(preNode, nextNode, value);
        preNode.next = insert;
        nextNode.pre = insert;
    }

    public void removeIndex(int index) {
        Node preNode = findNode(index - 1);
        if (preNode == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        Node remove = preNode.next;
        if (remove == tail) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        Node nextNode = remove.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    public void addLast(int value) {
        Node lastNode = tail.pre;
        Node inserted = new Node(lastNode, tail, value);
        lastNode.next = inserted;
        tail.pre = inserted;

    }

    public void removeLast() {
        Node removeNode = tail.pre;
        if (removeNode == head) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", 0));
        }
        Node preNode = removeNode.pre;
        preNode.next = tail;
        tail.pre = preNode;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p.next != tail;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }
}
