package Algorithm_Day3;


//递归找数组上的最大值
public class getMax {
    //arr[L...R]范围的最大值
    //复杂度O(N);
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, L);
        return Math.max(leftMax, rightMax);
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

}
