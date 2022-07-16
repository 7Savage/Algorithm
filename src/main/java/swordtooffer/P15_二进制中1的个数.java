package swordtooffer;

import org.junit.Test;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 */
public class P15_二进制中1的个数 {
//    根据 与运算 定义，设二进制数字 n ，则有：
//    若 n & 1 = 0 ，则 n 二进制 最右一位 为 0 ；
//    若 n & 1 = 1 ，则 n 二进制 最右一位 为 1

    //时间复杂度 O(logN)
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            //无符号右移
            n >>>= 1;
        }
        return res;
    }

    @Test
    public void test() {

        //数据在计算机中是以补码的形式存储的
        //正数的原码补码反码都一样,负数的原码换成反码第一位不变，其他位取反
        //正数 原码==反码==补码
        //负数 补码------->原码：符号位不变，其他位取反，再+1
        int a = -5;
        //有符号左移<< ：就是该数对应二进制码整体左移，左边超出的部分舍弃，右边补零
        System.out.println(a << 1);//1111 1011------->1111 0110
        //有符号右移>>：该数对应的二进制码整体右移，左边的用原有标志位补充，右边超出的部分舍弃
        System.out.println(a >> 1);//1111 1011------->1111 1110
        //无符号右移，管正负标志位为0还是1，将该数的二进制码整体右移，左边部分总是以0填充，右边部分舍弃
        System.out.println(a >>> 1);// 1111 1011------->0111 1110
        System.out.println("=========");
        int b = 5;
        System.out.println(b << 1);//0000 0101------->0000 1010
        System.out.println(b >> 1);//0000 0101------->0000 0010
        System.out.println(b >>> 1);//0000 0101------->0000 0010
        System.out.println("=========");
        byte c = -127;//byte的范围是 -128~127
        byte d= (byte) (c << 1);//当进行位运算时，强制转换成int类型，此处
        System.out.println(d);//1000 0001--------->0000 0010
    }

    @Test
    public void test2(){
        System.out.println(hammingWeight(11));
    }
}
