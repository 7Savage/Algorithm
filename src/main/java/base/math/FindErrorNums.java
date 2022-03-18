package base.math;

public class FindErrorNums {
    /**
     * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
     *
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
     *
     * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int repeat = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                repeat = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }
        int error = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                error = i + 1;
            }
        }
        return new int[]{repeat, error};
    }
}
