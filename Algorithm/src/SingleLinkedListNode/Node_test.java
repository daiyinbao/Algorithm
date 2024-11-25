package SingleLinkedListNode;

import org.junit.Test;

public class Node_test {
    @Test
    public void test1() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.loop((value) -> {
            System.out.println(value);
        });

    }

    @Test
    public void test2() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        for (Integer integer : singleLinkedList) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.loop2((value) -> {
            System.out.println("before:" + value);
        }, (value) -> {
            System.out.println("after:" + value);
        });
    }

    @Test
    public void test4() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.findValue(2));
    }

    @Test
    public void test5() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addIndex(1, 5);
        list.loop((value) -> {
            System.out.println(value);
        });
    }
}
