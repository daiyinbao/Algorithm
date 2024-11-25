package Algorithm_Day2;

public class DoubleNode{
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
        last=null;
        next=null;
    }
    //Ë«Á´±í·´×ª
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode next = null;
        DoubleNode pre = null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }
}