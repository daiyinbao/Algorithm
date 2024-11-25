package Algorithm_Day2;


//����ջʵ�ֶ���
/*
1.��pushջ�е�Ԫ�ص�����ջpop��ʹ�ú����pushջ�е�Ԫ������ջpop��ǰ���֣������ȳ�
* */
public class TwoStacksQueue {
    //��������ջ����
    private MyStack stackPush ;
    private MyStack stackPop ;

    public TwoStacksQueue() {
        stackPush = new MyStack();
        stackPop = new MyStack();
    }

    //��pushջ�е�Ԫ�ؼ���popջ��
    private void pushToPop(){
        if(stackPop.isEmpty()){//����ȷ��popջΪ�գ�������ᵷ��˳��
            while (!stackPush.isEmpty()){//���뽫pushջ�е�Ԫ��ȫ������popջ
                stackPop.push(stackPush.pop());
            }
        }
    }
    //����Ԫ��
    public void add(int pushInt) {
        stackPush.push(pushInt);
        pushToPop();//������pushջ��Ԫ�ص���popջ
    }

    //����Ԫ��,Ӧ�ȼ����Ƿ���Դ�pushջ�е������ݵ�popջ
    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();//����
        return stackPop.pop();
    }

    //��ʾջ��
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
