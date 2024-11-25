package DoublyLinkedList;


import java.util.Iterator;

public class DoublyLinkedList implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

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

    private Node sentinel = new Node(null, null, 888);

    public DoublyLinkedList() {
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }

    public void addFirst(int value) {
        Node p = sentinel;
        Node q = sentinel.next;
        Node insertedNode = new Node(p, q, value);
        p.next = insertedNode;
        q.pre = insertedNode;

    }

    public void addLast(int value) {
        Node p = sentinel;
        Node q = sentinel.pre;
        Node insertedNode = new Node(q, p, value);
        p.pre = insertedNode;
        q.next = insertedNode;
    }

    public void removeFirst() {
        Node p = sentinel;
        Node removeNode = sentinel.next;
        if (removeNode == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node q = removeNode.next;
        p.next = q;
        q.pre = p;
    }

    public void removeLast() {
        Node p = sentinel;
        Node removeNode = sentinel.pre;
        if (removeNode == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node q = removeNode.pre;
        q.next = p;
        p.pre = q;
    }

    public Node findNode(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void removeValue(int value) {
        Node removedNode = findNode(value);
        if (removedNode == null) {
            return;
        }
        Node p = removedNode.pre;
        Node q = removedNode.next;
        p.next = q;
        q.pre = p;
    }
}
