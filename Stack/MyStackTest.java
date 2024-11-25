package Stack;

import org.junit.Test;

public class MyStackTest {
    @Test
    public void test(){
        MyStackLinkedList<Integer> stack = new MyStackLinkedList<Integer>(10);
        for (int i = 0; i <15 ; i++) {
            stack.push(i*2);
        }
        //System.out.println(stack.peek());
        stack.pop();
        for (Integer ele:stack){
            System.out.println(ele);
        }
    }
    @Test
    public void test2(){
        MyStackArray<Integer> stack=new MyStackArray<Integer>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i*2);

        }
        stack.print();
        stack.pop();
        System.out.println("================");
        stack.print();
        /*for (Integer ele : stack) {
            System.out.println(ele);

        }*/

    }
}
