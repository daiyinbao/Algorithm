package Algorithm_Day2;


//运用单链表实现栈
public class MyStack {
    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyStack(){
        head = null;
        size=0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    //加入元素
    public void push(int value){
        Node cur = new Node(value);
        //第一个数
        if(head==null){
            head=cur;
        }
        else{
            cur.next=head;
            head=cur;
        }
        size++;
    }
    //弹出元素
    public int pop(){
        int ans=0;
        if(head!=null){
            ans = head.value;
            head=head.next;
            size--;
        }
        return ans;
    }
    public int peek(){
        return head != null ? head.value : null;
    }
}
