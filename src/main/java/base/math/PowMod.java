package base.math;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;


public class PowMod {
    @Test
    public void testMod() {
        System.out.println(-7 / 4); // -1
        System.out.println(-7 % 4); // -3
    }

    int base = 1337;

    /**
     * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出
     * 速度很慢
     *
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        int res = 1;
        a %= base;
        for (int i = b.length - 1; i >= 0; i--) {
            res = res * (myPow2(a, b[i])) % base;
            a = myPow2(a, 10);
        }
        return res;
    }

    /**
     * (a * b) % k = (a % k)(b % k) % k
     * 求 a 的 b 次方，除以 k
     *
     * @param a 常数
     * @param b 次方
     * @return
     */
    public int myPow(int a, int b) {

        int res = 1;
        a %= base;
        for (int i = 0; i < b; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }

    public int myPow2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        a %= base;
        //奇数
        if (b % 2 == 1) {
            return (myPow2(a, b - 1) * a) % base;
        } else {
            int sub = myPow2(a, b / 2);
            return sub * sub % base;
        }
    }

}
