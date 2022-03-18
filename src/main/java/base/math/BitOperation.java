package base.math;

import org.junit.Test;

public class BitOperation {
    //判断两个数是否异号
    @Test
    public void differentSign() {
        int x = -1, y = 2;
        boolean f = ((x ^ y) < 0); // true
        System.out.println(f);

        int x2 = 3, y2 = 2;
        boolean f2 = ((x2 ^ y2) < 0); // false
        System.out.println(f2);
    }

    //不用临时变量交换两个数
    @Test
    public void swap() {
        int a = 1, b = 2;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + " " + b);
    }

    @Test
    //加一
    public void addOne() {
        int n = 1;
        n = -~n;
        System.out.println(n);
    }

    @Test
    //减一
    public void minusOne() {
        int n = 2;
        n = ~-n;
        System.out.println(n);
    }

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     * <p>
     * 一个数如果是 2 的指数，那么它的二进制表示一定只含有一个 1
     * 2^0 = 1 = 0b0001
     * 2^1 = 2 = 0b0010
     * 2^2 = 4 = 0b0100
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
     * <p>
     * ^ 异或运算 同为0，异为1
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}
