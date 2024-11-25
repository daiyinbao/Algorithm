package Algorithm_Day2;

public class Node {
    public Node next;

    public int value;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    //单链表反转
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
