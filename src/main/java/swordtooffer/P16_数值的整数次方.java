package swordtooffer;

//求x的n次方
public class P16_数值的整数次方 {
    //时间复杂度：O(logN)
    public double myPow(double x, int n) {
        double res = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        //快速幂
        while (b != 0) {
            //判断 b 二进制最右一位是否为 1
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            //b 右移一位（可理解为删除最后一位）,有符号右移
            b >>= 1;
        }
        return res;
    }
}
