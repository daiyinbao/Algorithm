package DoubleLinkedList;

import org.junit.Test;

public class DoubleLinkedList_test {
    @Test
    public void test1() {
        DoubleLinkedList_ list = new DoubleLinkedList_();
        for (int i = 0; i < 5; i++) {
            list.addIndex(i + 1, i * 2);
        }
        list.addLast(8);
        list.removeIndex(3);
        list.removeLast();

        for (Integer ele : list) {
            System.out.println(ele);
        }
    }
}
