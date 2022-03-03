package swordtooffer;

public class P44_数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;
        while (count < n) {
            n -= count;
            start *= 10;
            digit++;
            count =9 * start * digit;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt(((n - 1) % digit)) - '0';
    }
}
