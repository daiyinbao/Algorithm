package Algorithm_Day2;

import java.util.Date;

public class Algorithm02 {
    //单链表反转
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1 = n1.reverseLinkedList(n1);
        while (n1!=null){
            System.out.println(n1.value + "  ");
            n1 = n1.next;
        }
        System.out.println();
    }
}

