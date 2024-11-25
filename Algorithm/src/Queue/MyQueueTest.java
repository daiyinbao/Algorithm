package Queue;

import org.junit.Test;

public class MyQueueTest {
    @Test
    public void test1(){
        MyArrayQueue1<Integer> queue = new MyArrayQueue1<Integer>(5);
        for (int i = 0; i < 5; i++) {
            queue.offer(i*2);
        }
        queue.poll();
        for(Integer ele :queue){
            System.out.println(ele);
        }
        //queue.poll();
        System.out.println("=========================");
    }

    @Test
    public void test2(){
        MyQueue<Integer> queue = new MyQueue<Integer>(5);
        for (int i = 0; i < 5; i++) {
            queue.offer(i*2);
        }
        for(Integer ele :queue){
            System.out.println(ele);
        }
    }
}
