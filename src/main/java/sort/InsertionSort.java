package sort;

import java.util.Arrays;

/**
 * 1. 把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
 * 2. 从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
 * 3. 重复上述过程直到最后一个元素被插入有序子数组中。
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;
            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = value;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 3, 6, 2, 1, 7, 4};
        sort(arr);
    }
}
