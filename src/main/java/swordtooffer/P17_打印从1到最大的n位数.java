package swordtooffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 元素无重可复选
 */
public class P17_打印从1到最大的n位数 {

    int count = 0;
    int res[];

    //大数+DFS
    //时间复杂度：O(10^n)
    public int[] printNumbers(int n) {
        res = new int[(int) Math.pow(10, n) - 1];
        char[] num;
        for (int digit = 1; digit <= n; digit++) {
            //为了避免数字开头出现0，先把首位first固定
            for (char first = '1'; first <= '9'; first++) {
                //根据层数来规定num的大小
                num = new char[digit];
                //固定首位
                num[0] = first;
                dfs(1, digit, num);
            }
        }
        return res;
    }


    public void dfs(int index, int digit, char[] num) {
        //递归的中止条件为已经生成了digit位的数字
        if (index == digit) {
            //将字符数组转化为数字
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        //生成首位之后进入递归生成剩下的digit - 1位数，从0~9中取值
        for (char i = '0'; i <= '9'; i++) {
            num[index] = i;
            dfs(index + 1, digit, num);
        }
    }

}
