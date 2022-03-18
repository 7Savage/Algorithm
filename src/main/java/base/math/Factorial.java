package base.math;

//阶乘
public class Factorial {
    /**
     * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        int divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
