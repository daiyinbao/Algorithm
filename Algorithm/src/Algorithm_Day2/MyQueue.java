package Algorithm_Day2;

public class MyQueue{
    private Node head;
    private Node tail;
    private int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    //����Ԫ��
    public void offer(int value){
        Node cur = new Node(value);
        if(tail==null){
            head=cur;
            tail=cur;
        }
        else{//ԭ�������д�����ֵ
            tail.next = cur;
            tail=cur;
        }
        size++;
    }
    //����Ԫ��
    public int poll(){
        int ans=0;
        if(head!=null){
            ans=head.value;
            head=head.next;
            size--;
        }
        if(head==null){
            tail=null;
        }
        return ans;
    }
    //������ֻȡֵ
    public int peek(){
        int ans =0;
        if(head!=null){
            ans = head.value;
        }
        return ans;
    }
}
