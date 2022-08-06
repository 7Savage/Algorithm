package hot;

public class P215_数组中的第K个最大元素 {
    int target;
    public int findKthLargest(int[] nums, int k) {
        target = nums.length - k;
        quickSort(nums, 0, nums.length - 1);
        return nums[target];
    }

    public void quickSort(int[] nums, int left, int right){
        if (left < right) {
            int mid = partition(nums, left, right);
            if (mid == target){
                return;
            }
            quickSort(nums, left, mid -1);
            quickSort(nums, mid + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
