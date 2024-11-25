package Algorithm_Day2;


//利用数组实现栈
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
        //加入元素
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

        //弹出元素
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
        //检验下标是否超过数组长度
        private int nextIndex(int i){
            return i<limit-1?i+1:0;
        }

}
