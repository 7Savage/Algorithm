package base.math;

import java.util.Arrays;

public class PrimeNumber {
    /**
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime2(i)) {
                res++;
            }
        }
        return res;
    }

    //O(N)超时
    public boolean isPrime1(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //O(sqrt(N)) 超时，后两个乘积就是前面两个反过来，反转临界点就在 sqrt(n)。
    public boolean isPrime2(int num) {
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //时间复杂度：O(N * loglogN)
    public int countPrimes2(int n) {
        int res = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
            }
        }
        return res;
    }


}
