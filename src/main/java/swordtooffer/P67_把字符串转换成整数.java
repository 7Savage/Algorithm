package swordtooffer;

/**
 * 基本类型：int 二进制位数：32
 * 包装类：java.lang.Integer
 * 最小值：Integer.MIN_VALUE= -2147483648 （-2的31次方）
 * 最大值：Integer.MAX_VALUE= 2147483647  （2的31次方-1）
 */
public class P67_把字符串转换成整数 {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int i = 0;
        int sign = 1;//符号位
        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;
        if (chars[0] == '-') {
            sign = -1;
            i = 1;
        }
        if (chars[0] == '+') {
            i = 1;
        }

        while (i < chars.length) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            if (res > boundary || (res == boundary && chars[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            int x = chars[i] - '0';
            res = res * 10 + x;
            i++;
        }
        return sign * res;
    }
}
