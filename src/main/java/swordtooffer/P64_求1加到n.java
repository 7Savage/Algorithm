package swordtooffer;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class P64_求1加到n {
    //递归，但是不符合题意
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        n += sumNums(n - 1);
        return n;
    }

    int res = 0;
    //时间复杂度 O(n)： 计算 n + (n-1) + ... + 2 + 1n+(n−1)+...+2+1 需要开启 n 个递归函数。
    //空间复杂度 O(n) ： 递归深度达到 n ，系统使用 O(n) 大小的额外空间。
    public int sumNums2(int n) {
        boolean x = (n > 1 && sumNums2(n - 1) > 0);
        res += n;
        return res;
    }
}
