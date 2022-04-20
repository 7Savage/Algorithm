package swordtooffer;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
public class P56_I数组中数字出现的次数 {

    //异或运算，两个相同数字异或为 0
    //x^0 = x
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        int a = 0, b = 0;
        //辅助变量
        int m = 1;
        //遍历 nums 执行异或：剩下a^b
        for (int num : nums) {
            n ^= num;
        }
        //获取 a^b 的首位1
        //若整数 a^b 某二进制位为 1 ，则 a 和 b 的此二进制位一定不同
        //m作为辅助变量，来区分a和b
        while ((n & m) == 0) {
            //左移一位
            m = m << 1;
        }
        //分别遍历两个子数组执行异或
        for (int num : nums) {
            if ((m & num) == 0) a ^= num; // 若 num & m != 0 , 划分至子数组 1 ，执行遍历异或
            else b ^= num;// 若 num & m != 0 , 划分至子数组 1 ，执行遍历异或
        }
        return new int[]{a, b};
    }
}
