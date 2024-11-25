package DeQueue;

/**
 * 双端队列-->使用数组实现
 * author：左程云
 * 使用size优化循环数组，有一个空间不能使用的问题
 */

public class ArrayDeQueue2 {

    public int[] deque;
    public int l, r, size, limit;

    public ArrayDeQueue2(int k) {
        deque = new int[k];
        l = r = size = 0;
        limit = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                l = l == 0 ? (limit - 1) : (l - 1);
                deque[l] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                r = r == limit - 1 ? 0 : (r + 1);
                deque[r] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            l = (l == limit - 1) ? 0 : (l + 1);
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            r = r == 0 ? (limit - 1) : (r - 1);
            size--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[l];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[r];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

}
