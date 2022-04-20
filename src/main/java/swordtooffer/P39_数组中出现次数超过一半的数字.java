package swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class P39_数组中出现次数超过一半的数字 {
    //时间和空间复杂度均为 O(N)
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() > len / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    //时间复杂度均为 O(N)
    //空间复杂度为 O(1)
    public int majorityElement2(int[] nums) {
        int vote = 0;
        int x = 0;
        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            vote += (num == x ? 1 : -1);
        }
        return x;
    }
}
