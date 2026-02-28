package Stack;

import java.util.Iterator;

public class MyStackArray<E> implements Stack<E>, Iterable<E> {
    private E[] array;
    private int top = 0;
    private int capacity;

    public MyStackArray(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    /**
     *
     * 使用数组实现栈时，调用pop方法，元素并没有直接从数组中删除，元素仍在top-1位置，
     * 只是指针不会在引用它
     */

    public E pop() {
        if(isEmpty()){
            return null;
        }
        E popValue = array[top - 1];
        top--;
        return popValue;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p=top;
            @Override
            public boolean hasNext() {
                return p>0;
            }

            @Override
            public E next() {
                E value =array[p-1];
                p--;
                return value;
            }
        };
    }
    public void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
