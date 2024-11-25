package Stack;

public interface Stack<E> {
    /**
     * ��ջ��ѹ��Ԫ��
     *
     * @param value ��ѹ��ֵ
     * @return ѹ��ɹ����� true, ���򷵻� false
     */
    boolean push(E value);

    /**
     * ��ջ������Ԫ��
     *
     * @return ջ�ǿշ���ջ��Ԫ��, ջΪ�շ��� null
     */
    E pop();

    /**
     * ����ջ��Ԫ��, ������
     *
     * @return ջ�ǿշ���ջ��Ԫ��, ջΪ�շ��� null
     */
    E peek();

    /**
     * �ж�ջ�Ƿ�Ϊ��
     *
     * @return �շ��� true, ���򷵻� false
     */
    boolean isEmpty();

    /**
     * �ж�ջ�Ƿ�����
     *
     * @return ������ true, ���򷵻� false
     */
    boolean isFull();
}
