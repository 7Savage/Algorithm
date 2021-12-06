package sort;

import java.util.Arrays;

/**
 * 1. 从数列中挑出一个元素，称为"基准"（pivot），
 * 2. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 3. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 3, 6, 2, 1, 7, 4};
        sort(arr, 0, arr.length - 1);
    }
}
