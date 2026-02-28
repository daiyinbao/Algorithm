package Algorithm_Day2;



public class DoubleQueue {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;
    public DoubleQueue(){
        head=null;
        tail=null;
        size=0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    //从头部加入
    public void pushHead(int value){
        DoubleNode cur = new DoubleNode(value);
        if(head==null){
            head=cur;
            tail=cur;
        }
        else{
            cur.next=head;
            head.last=cur;
            head=cur;
        }
        size++;
    }
    //从尾部加入
    public void pushTail(int value){
        DoubleNode cur = new DoubleNode(value);
        if(head==null){
            head=cur;
            tail=cur;
        }
        else{
            tail.next=cur;
            cur.last=tail;
            tail=cur;
        }
        size++;
    }
    //从头部弹出
    public int popHead(){
        int ans=0;
        if(head==null){
            return ans;
        }
        size--;
        ans=head.value;
        if(head==tail){
            head=null;
            tail=null;
        }
        else{
            head=head.next;
            head.last=null;
        }
        return ans;
    }
    //从尾部弹出
    public int popTail(){
        int ans=0;
        if(tail==null){
            return ans;
        }
        size--;
        ans=head.value;
        if(head==tail){
            head=null;
            tail=null;
        }
        else{
            tail=tail.last;
            tail.next=null;
        }
        return ans;
    }
}
