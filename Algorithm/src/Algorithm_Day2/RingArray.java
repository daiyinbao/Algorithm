package Algorithm_Day2;


//��������ʵ��ջ
public class RingArray {
        private int[] array;
        private int pushI;
        private int pollI;
        private int size;
        private int limit;
        public RingArray(int limit){
            array = new int[limit];
            pollI=0;
            pushI=0;
            size=0;
            this.limit=limit;
        }
        //����Ԫ��
        public void push(int value){
            if(size==limit){
                throw new RuntimeException("fulled");
            }
            else{
                size++;
                array[pushI]=value;
                pushI=nextIndex(pushI);
            }
        }

        //����Ԫ��
        public int pop(){
            if(size==limit){
                throw new RuntimeException("fulled");
            }
            else{
                size--;
                int ans = array[pollI];
                pollI=nextIndex(pollI);
                return ans;
            }

        }

        public boolean isEmpty() {
            return size == 0;
        }
        //�����±��Ƿ񳬹����鳤��
        private int nextIndex(int i){
            return i<limit-1?i+1:0;
        }

}
