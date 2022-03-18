package swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 取模运算是求两个数相除的余数==取余
 */
public class P10_I斐波那契数列 {

    /**
     * 递归法
     * 原理： 把 f(n)f(n) 问题的计算拆分成 f(n-1)和 f(n-2) 两个子问题的计算，并递归，以 f(0) 和 f(1)为终止条件。
     * 缺点： 大量重复的递归计算，例如 f(n) 和 f(n - 1) 两者向下递归需要 各自计算 f(n - 2) 的值。
     * 时间复杂度：O(2^N)
     * 空间复杂度：O(N)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        n = help(n);
        return n;
    }

    private int help(int n) {
        if (n < 2) return n;
        return (help(n - 1) + help(n - 2)) % 1000000007;
    }

    /**
     * 记忆递归法
     * 原理： 在递归法的基础上，新建一个长度为 n 的数组，用于在递归时存储 f(0)至 f(n) 的数字值，重复遇到某数字则直接从数组取用，避免了重复的递归计算。
     * 缺点： 记忆化存储需要使用 O(N) 的额外空间。
     */
    Map<Integer, Integer> hashMap = new HashMap<>();

    public int fib2(int n) {
        if (n < 2) return n;

        if (hashMap.get(n) != null) {
            return hashMap.get(n);
        }
        int sum = (fib2(n - 1) + fib2(n - 2)) % 1000000007;
        hashMap.put(n, sum);
        return sum;
    }

    /**
     * 时间复杂度 O(N) ： 计算 f(n) 需循环 n 次，每轮循环内计算操作使用 O(1) 。
     * 空间复杂度 O(1) ： 几个标志变量使用常数大小的额外空间。
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }



    /**
     * 时间复杂度：O(logn)。
     *
     * 空间复杂度：O(1)。
     * @param n
     * @return
     */
    static final int MOD = 1000000007;
    public int fib4(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }



}
