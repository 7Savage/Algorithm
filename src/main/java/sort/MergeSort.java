package sort;

import java.util.Arrays;

/**
 * 1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4. 重复步骤3直到某一指针到达序列尾
 * 5. 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        //当left==right的时，已经不需要再划分了
        if (left < right) {
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < k; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 3, 6, 2, 1, 7, 4};
        mergeSort(arr, 0, arr.length - 1);
    }
}
