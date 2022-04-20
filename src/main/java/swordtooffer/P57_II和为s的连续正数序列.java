package swordtooffer;

import java.util.ArrayList;
import java.util.List;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
public class P57_II和为s的连续正数序列 {
    //时间复杂度：O(N)
    //空间复杂度: O(1)
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2;
        int s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] temp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    temp[k - i] = k;
                }
                res.add(temp);
            }
            if (s >= target) {
                s -= i;
                i++;
            }
            if (s < target) {
                j++;
                s += j;
            }
        }
        //toArray(new T[0])能够运行是因为java做了优化，能动态生成对应大小的数组，是官方建议的书写方式，能避免某些并发问题并且效率更高
        return res.toArray(new int[0][]);
    }
}
