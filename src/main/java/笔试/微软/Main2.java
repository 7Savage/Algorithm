package 笔试.微软;

import java.util.HashMap;
import java.util.Map;
//// 第二题，x[i]/y[i] + x[j]/y[i] = 1的pair数，对1e9+7取模
//// 思路：双指针，两数之和
public class Main2 {
    public int solution(int[] A, int[] B) {
        int count = 0;
        int mod = 1000000007;
        int lcm = findLCM(B);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            A[i] *= lcm / B[i];
            count += map.getOrDefault(lcm - A[i], 0);
            count %= mod;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        return count;
    }

    private int findLCM(int[] B) {
        int[] nums = B.clone();
        int div = 2;
        int lcm = 1;
        int count = 0;
        for (int num : nums)
            if (num == 1)
                count++;
        while (true) {
            boolean divides = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) return 0;
                if (nums[i] != 1 && nums[i] % div == 0) {
                    divides = true;
                    nums[i] = nums[i] / div;
                    if (nums[i] == 1) {
                        count++;
                    }
                }
            }
            if (divides) {
                lcm *= div;
            } else {
                div++;
            }

            if (count == nums.length) return lcm;
        }
    }
}
