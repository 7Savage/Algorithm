package swordtooffer;

public class P56_I数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        int a = 0, b = 0;
        int m = 1;
        for (int num : nums) {
            n ^= num;
        }
        while ((n & m) == 0) {
            m = m << 1;
        }
        for (int num : nums) {
            if ((m & num) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
