package swordtooffer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class P43_1到n整数中1出现的次数 {
    //时间复杂度 O(logn) ： 循环内的计算操作使用 O(1)时间；循环次数为数字n 的位数，即 log10n ，因此循环使用 O(logn) 时间。
    //空间复杂度 O(1) ： 几个变量使用常数大小的额外空间。
    public int countDigitOne(int n) {
        int res = 0;
        int digit = 1;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        //当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
        while (high != 0 || cur != 0) {
            //当 cur = 0 时： 此位 1 的出现次数只由高位 high 决定
            if (cur == 0) {
                res += digit * high;
            }
            //当 cur = 1 时： 此位 1 的出现次数由高位 high 和低位 low 决定
            else if (cur == 1) {
                res += digit * high + low + 1;
            }
            //当 cur=2,3,⋯,9 时： 此位 11 的出现次数只由高位 high 决定
            else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
