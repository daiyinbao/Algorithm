package Stack;

import java.util.Iterator;

public class MyStackLinkedList<E> implements Stack<E>, Iterable<E> {
    private int capacity;
    private int size = 0;

    public MyStackLinkedList(int capacity) {
        this.capacity = capacity;
    }

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<E>(null, null);//½áµã

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> insertedNode = new Node<>(value, head.next);
        head.next = insertedNode;
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> firstNode = head.next;
        head.next = firstNode.next;
        size--;
        return firstNode.value;
    }

    @Override
    public E peek() {
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
