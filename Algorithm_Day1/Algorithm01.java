package Algorithm_Day1;

//���ÿ�ݼ�
/*
 * main����-->psvm��main
 * System.out.println();-->sout
 * ����ѡȡ������-->ctrl + d
 * �����ƶ�-->ctrl + shift + ��ͷ
 * ��������/����--> alt + enter
 * (ȡ��)����ע��-->ctrl + /
 * ��ȡ��������ע��-->ctrl + shift + /
 * ѡȡ�������for/if/try-catch����� -->ctrl + alt + t
 * getter/setter����-->alt + insert
 * */
public class Algorithm01 {

    //ð������
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e >= 0; e--) {
            for (int i = 0; i < e; i++) {//��0-N-1��ʼ�������飬�����ֵȷ�����ٴ�0-N-2��������
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    //ѡ������
    public static void SelectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;//�ж�jλ�õ�����minIndexλ�����Ĵ�С����j��С����minIndexΪj
            }
            swap(arr, i, minIndex);

        }
    }

    //��������
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {//���j������j+1���򽻻�������λ��
                swap(arr, j, j + 1);
            }
        }
    }

    //������������
    //Math.random()����ȸ��ʷ���[0,1)
    //Math.random()*N  -->[0,N)
    //(int)(Math.random()*N)  -->[0,N-1)
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());//��������
        }
        return arr;
    }

    //swap,����Ҫ�����µ��ڴ�ռ䣻
    //������ָ����ڴ�Ϊ��ͬ�ռ䣬����Խ�����ָ����ڴ�Ϊ��ͬ�ռ䣬��ֵ��Ϊ0��
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    //���ַ�
    /*

     */
    //�������������Ƿ���������
    public static boolean exist(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] == num;
    }

    //������>=value������ߵ���
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    //�ֲ���Сֵ���⣨ֻ����һ�� ��,������������������һ�������
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] < arr[mid - 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    //�������-->�޽�λ���

    //һ�������У���һ���������������Σ���������������ż���Σ���ô�ҵ�����ӡ������
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    //һ��int ��ȡ�����Ҳ��1
    public static void findRightOne(int num) {
        int n = num & (~num + 1);
        System.out.println(n);
    }

    //һ�������У���2���������������Σ���������������ż���Σ���ô�ҵ�����ӡ��2����
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 5, 4, 18, 11};
        int[] arr1 = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        printArray(arr);
        insertSort(arr);
        printArray(arr);
        System.out.println(exist(arr, 1));
        System.out.println(nearestIndex(arr, 8));
        //printOddTimesNum1(arr1);
        findRightOne(12);
        printOddTimesNum2(arr1);
    }
}
