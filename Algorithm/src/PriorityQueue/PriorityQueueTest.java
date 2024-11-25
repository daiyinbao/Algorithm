package PriorityQueue;

import org.junit.Test;

public class PriorityQueueTest {
    @Test
    public void test(){
        PriorityQueue3<Entry> queue = new PriorityQueue3<Entry>(5);
        queue.offer(new Entry("dai",1));
        queue.offer(new Entry("dai",2));
        queue.offer(new Entry("dai",3));
        queue.offer(new Entry("dai",4));
        queue.offer(new Entry("dai",5));
        queue.offer(new Entry("dai",6));
        System.out.println(queue.peek());
        System.out.println(queue.poll().priority);
        System.out.println(queue.poll().priority);
        System.out.println(queue.poll().priority);
        System.out.println(queue.poll().priority);
        System.out.println(queue.poll().priority);


    }
}
