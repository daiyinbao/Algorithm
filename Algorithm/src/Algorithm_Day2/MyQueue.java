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
    //加入元素
    public void offer(int value){
        Node cur = new Node(value);
        if(tail==null){
            head=cur;
            tail=cur;
        }
        else{//原来队列中存在有值
            tail.next = cur;
            tail=cur;
        }
        size++;
    }
    //弹出元素
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
    //不弹出只取值
    public int peek(){
        int ans =0;
        if(head!=null){
            ans = head.value;
        }
        return ans;
    }
}
