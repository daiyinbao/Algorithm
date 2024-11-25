package Algorithm_Day1;

//常用快捷键
/*
 * main方法-->psvm或main
 * System.out.println();-->sout
 * 复制选取行内容-->ctrl + d
 * 代码移动-->ctrl + shift + 箭头
 * 创建对象/导包--> alt + enter
 * (取消)单行注释-->ctrl + /
 * （取消）多行注释-->ctrl + shift + /
 * 选取代码放入for/if/try-catch语句中 -->ctrl + alt + t
 * getter/setter方法-->alt + insert
 * */
public class Algorithm01 {

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e >= 0; e--) {
            for (int i = 0; i < e; i++) {//从0-N-1开始遍历数组，将最大值确定，再从0-N-2。。。。
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    //选择排序
    public static void SelectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;//判断j位置的数与minIndex位置数的大小，若j更小，则minIndex为j
            }
            swap(arr, i, minIndex);

        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {//如果j数大于j+1，则交换两数的位置
                swap(arr, j, j + 1);
            }
        }
    }

    //随机数组产生器
    //Math.random()随机等概率返回[0,1)
    //Math.random()*N  -->[0,N)
    //(int)(Math.random()*N)  -->[0,N-1)
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());//正负均有
        }
        return arr;
    }

    //swap,不需要创建新的内存空间；
    //当两书指向的内存为不同空间，则可以交换，指向的内存为相同空间，则值变为0；
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

    //二分法
    /*

     */
    //找有序数组中是否存在这个数
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

    //找满足>=value的最左边的数
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

    //局部最小值问题（只需找一个 ）,其中数组相邻两个数一定不相等
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

    //异或运算-->无进位相加

    //一个数组中，有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
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

    //一个int 提取出最右侧的1
    public static void findRightOne(int num) {
        int n = num & (~num + 1);
        System.out.println(n);
    }

    //一个数组中，有2种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这2种数
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
