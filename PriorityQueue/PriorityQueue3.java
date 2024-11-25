package PriorityQueue;

import Queue.Queue;

/**
 * ���ȼ�����-->���ݴ󶥶�ʵ��
 * author:����
 * ���ڵ�����ȼ���
 *
 * @param <E>
 */


public class PriorityQueue3<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    /**
     * 1. �����Ԫ��, ���뵽����ĩβ (����λ�� child)
     * 2. ���ϱȽ��¼�Ԫ���������ڵ�(parent)���ȼ� (�ϸ�)
     * - ������ڵ����ȼ���, �������ƶ�, ���ҵ���һ�� parent
     * - ֱ�����ڵ����ȼ����߻� child==0 Ϊֹ
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return false;
    }

    /**
     * 1. �����Ѷ���β��Ԫ��, ��β��Ԫ�س���
     * 2. (��Ǳ)
     * - �ӶѶ���ʼ, ����Ԫ�����������ӽϴ��߽���
     * - ֱ����Ԫ�ش�����������, ��û�к���Ϊֹ
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        Priority e = array[size];
        array[size] = null; // help GC

        // ��Ǳ
        down(0);

        return (E) e;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent; // ���踸Ԫ�����ȼ����
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != parent) { // �к��ӱȸ��״�
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }


    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

}
