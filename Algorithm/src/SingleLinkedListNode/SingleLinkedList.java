package SingleLinkedListNode;

import java.util.Iterator;
import java.util.function.Consumer;

public class SingleLinkedList implements Iterable<Integer> {
    //头指针
    Node_ head = null;


    private static class Node_ {
        int value;
        Node_ next;

        public Node_(int value, Node_ next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        //head=new Node_(value,null);//链表为空
        head = new Node_(value, head);//链表非空
    }

    public void foreach(Consumer<Integer> consumer) {
        Node_ p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop(Consumer<Integer> consumer) {
        for (Node_ p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    public void loop2(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(head, before, after);

    }

    public void recursion(Node_ node, Consumer<Integer> before, Consumer<Integer> after) {
        if (node == null) {
            return;
        }
        before.accept(node.value);
        recursion(node.next, before, after);
        after.accept(node.value);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node_ p = head;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    private Node_ findLast() {

        if (head == null) {
            return null;
        }
        Node_ p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public void addLast(int value) {
        Node_ last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node_(value, null);
    }

    private Node_ findNode(int index) {
        int i = 0;
        for (Node_ p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int findValue(int index) {
        Node_ node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        return node.value;
    }

    public void addIndex(int index, int value) {
        if (index == 0) {
            addLast(value);
            return;
        }
        Node_ prevNode = findNode(index - 1);
        if (prevNode == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        prevNode.next = new Node_(value, prevNode.next);

    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("空链表");
            return;
        }
        head = head.next;
    }

    public void removeIndex(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node_ prevNode = findNode(index - 1);
        if (prevNode == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        Node_ remove = prevNode.next;
        if (remove == null) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        prevNode.next = remove.next;
    }


}
