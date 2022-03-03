package swordtooffer;

import java.util.ArrayList;
import java.util.List;

public class P57_II和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        int j = 1;
        int sum = 0;
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                list.add(arr);
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
