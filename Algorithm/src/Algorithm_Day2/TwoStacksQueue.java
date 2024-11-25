package Algorithm_Day2;


//两个栈实现队列
/*
1.将push栈中的元素倒入新栈pop，使得后进入push栈中的元素在新栈pop的前部分，可以先出
* */
public class TwoStacksQueue {
    //创建两个栈对象
    private MyStack stackPush ;
    private MyStack stackPop ;

    public TwoStacksQueue() {
        stackPush = new MyStack();
        stackPop = new MyStack();
    }

    //将push栈中的元素加入pop栈中
    private void pushToPop(){
        if(stackPop.isEmpty()){//必须确保pop栈为空，否则则会捣乱顺序
            while (!stackPush.isEmpty()){//必须将push栈中的元素全部倒入pop栈
                stackPop.push(stackPush.pop());
            }
        }
    }
    //加入元素
    public void add(int pushInt) {
        stackPush.push(pushInt);
        pushToPop();//将加入push栈的元素导入pop栈
    }

    //导出元素,应先检验是否可以从push栈中导入数据到pop栈
    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();//检验
        return stackPop.pop();
    }

    //显示栈顶
    public int peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }


}
