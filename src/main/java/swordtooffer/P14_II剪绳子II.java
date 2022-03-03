package swordtooffer;

import org.junit.Test;

public class P14_II剪绳子II {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        int a = n / 3 - 1;
        while (a > 0) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
            a >>= 1;
        }

        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(120));
    }
}
