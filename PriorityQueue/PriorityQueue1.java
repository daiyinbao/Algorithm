package PriorityQueue;


import Queue.Queue;

/**
 * 优先级队列-->基于无序数组的实现,出队难，入队容易
 * author:黑马
 * 一端进，一端优先级高的元素先出
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array=new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        array[size++]=value;
        return false;
    }

    /**
     * 根据优先级删除数据
     * 该方法判断优先级
     * return 优先级最高的索引
     */
    private int selMaxPriority(){
        int max=0;
        for (int i = 1; i <size ; i++) {
            if(array[i].priority()>array[max].priority()){
                max=i;
            }

        }
        return max;
    }

    /**
     * 删除元素
     * @return
     */
    private void remove(int index){
        if(index<size-1){
            System.arraycopy(array,index+1,array,index,size-index-1);
        }
        size--;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        int max=selMaxPriority();
        E pollValue=(E)array[max];
        remove(max);
        return pollValue;
    }


    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E) array[selMaxPriority()];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==array.length;
    }
}
