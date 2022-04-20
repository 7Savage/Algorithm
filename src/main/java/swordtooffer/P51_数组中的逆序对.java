package swordtooffer;

import org.junit.Test;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 「归并排序」与「逆序对」是息息相关的。归并排序体现了 “分而治之” 的算法思想
 */
public class P51_数组中的逆序对 {
    int res = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    //时间复杂度 O(NlogN) ： 其中 N 为数组长度；归并排序使用 O(NlogN) 时间；
    //空间复杂度 O(N) ： 辅助数组 tmp 占用 O(N) 大小的额外空间；

    private void mergeSort(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            //注意跟快排有区别
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int k = 0;
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                //归并排序唯一添加的部分
                //添加右子数组当前元素 tmp[j]，并执行 j = j + 1 ；此时构成 m - i + 1 个「逆序对」，统计添加至 res
                res += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            nums[left + l] = temp[l];
        }
    }

    @Test
    public void test() {
        int[] nums = {7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }
}
