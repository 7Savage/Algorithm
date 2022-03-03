package hot100;

import org.junit.Test;

public class P215_数组中的第K个最大元素 {
    int k;

    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high, base = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= base) j--;
            while (i < j & nums[i] >= base) i++;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        if (j == k - 1) return;
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }
}
