package sort;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else {
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 3, 6, 2, 1, 7, 4};
        sort(arr);
    }
}
