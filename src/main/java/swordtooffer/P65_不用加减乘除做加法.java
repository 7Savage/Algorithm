package swordtooffer;

public class P65_不用加减乘除做加法 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;//进位
            a ^= b;//非进位
            b = c;
        }
        return a;
    }
}
