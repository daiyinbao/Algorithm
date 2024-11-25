package DynamicArray;


import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int Capacity = 10;
    private int[] dynamicArray = {};

    public void addLast(int element) {
        /*dynamicArray[size] = element;
        size++;*/
        add(size, element);
    }

    public void add(int index, int element) {
        //����
        checkAndGrow();
        if (size < Capacity - 1) {
            if (index >= 0 && index < size) {
                /*public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);*/
                System.arraycopy(dynamicArray, index, dynamicArray, index + 1, size - index);
            }
            dynamicArray[index] = element;
            size++;
        }
    }

    public int get(int index) {
        if (index > size - 1) {
            return 0;
        }
        return dynamicArray[index];
    }

    //����ʽ�ӿ�-->����
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(dynamicArray[i]);
        }

    }

    //����������
    //�÷����ĵ���-->��ǿforѭ��������������
    @Override
    public Iterator<Integer> iterator() {
        //�����ڲ���
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return dynamicArray[i++];
            }

        };
    }

    //���ı���
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(dynamicArray,0,size));
    }

    //Ԫ�ص�ɾ��
    public int remove(int index){
        int remove=dynamicArray[index];
        if(index<size-1){
            System.arraycopy(dynamicArray,index+1,dynamicArray,index,size-index-1);
        }
        size--;
        return remove;
    }

    //����
    public void checkAndGrow(){
        if(size==0){
            dynamicArray=new int[Capacity];
        }
        if(size==Capacity){
            Capacity+=Capacity>>2;
            int[] newArray=new int[Capacity];
            System.arraycopy(dynamicArray,0,newArray,0,size);
            dynamicArray=newArray;
        }
    }


}
