package swordtooffer;

//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//
//请写一个函数，求任意第n位对应的数字。
public class P44_数字序列中某一位的数字 {
    //时间复杂度 O(logn) ： 所求数位 n 对应数字 num 的位数 digit 最大为 O(logn) ；第一步最多循环 O(logn) 次；第三步中将 num 转化为字符串使用 O(logn) 时间；因此总体为 O(logn) 。
    //空间复杂度 O(logn) ： 将数字 num 转化为字符串 str(num) ，占用 O(logn) 的额外空间。
    public int findNthDigit(int n) {
        //start每次乘10，可能超出int范围，比如n=10 0000 0000时；start是long，那count和num就得是long
        long start = 1;
        long count = 9;
        int digit = 1;
        //1. 确定所求数位的所在数字的位数
        while (n > count) {
            n -= count;
            start *= 10;
            digit++;
            count = start * digit * 9;
        }
        //2. 确定所求数位所在的数字
        long num = start + (n - 1) / digit;
        //3. 确定所求数位在 num 的哪一数位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
