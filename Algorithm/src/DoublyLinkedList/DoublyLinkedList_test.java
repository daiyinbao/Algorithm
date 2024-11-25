package DoublyLinkedList;

import org.junit.Test;

public class DoublyLinkedList_test {
    @Test
    public void test01() {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i * 2);
        }
        for (Integer ele : list) {
            System.out.println(ele);
        }
    }

    @Test
    public void test02() {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            list.addLast(i * 2);
        }
        list.removeLast();
        for (Integer ele : list) {
            System.out.println(ele);
        }

    }
    @Test
    public void test03() {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            list.addLast(i * 2);
        }
        list.removeValue(2);
        for (Integer ele : list) {
            System.out.println(ele);
        }

    }
}
