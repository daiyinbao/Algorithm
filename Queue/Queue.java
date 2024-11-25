package Queue;

public interface Queue<E> {

    /**
     * �����β����ֵ. �е�ϰ������Ϊ enqueue
     *
     * @param value ������ֵ
     * @return ����ɹ����� true, ����ʧ�ܷ��� false
     */
    boolean offer(E value);

    /**
     * �Ӷ���ͷ��ȡֵ, ���Ƴ�. �е�ϰ������Ϊ dequeue
     *
     * @return ������зǿշ��ض�ͷֵ, ���򷵻� null
     */
    E poll();

    /**
     * �Ӷ���ͷ��ȡֵ, ���Ƴ�
     *
     * @return ������зǿշ��ض�ͷֵ, ���򷵻� null
     */
    E peek();

    /**
     * �������Ƿ�Ϊ��
     *
     * @return �շ��� true, ���򷵻� false
     */
    boolean isEmpty();

    /**
     * �������Ƿ�����
     *
     * @return ������ true, ���򷵻� false
     */
    boolean isFull();
}

