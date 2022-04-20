package swordtooffer;

//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
public class P65_不用加减乘除做加法 {

    //时间复杂度 O(1)： 最差情况下（例如 a = 0x7fffffff , b = 1 时），需循环 32 次，使用 O(1) 时间；每轮中的常数次位操作使用 O(1) 时间。
    //空间复杂度 O(1)： 使用常数大小的额外空间。
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;//进位
            a ^= b;//非进位
            b = c;
        }
        return a;
    }
}
