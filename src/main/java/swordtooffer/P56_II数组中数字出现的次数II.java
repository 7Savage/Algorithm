package swordtooffer;

import java.util.HashMap;
import java.util.Map;
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
public class P56_II数组中数字出现的次数II {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            map.put(key, map.getOrDefault(key, 0));
        }

        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }

    //时间复杂度 O(N) ： 其中 N 位数组 nums 的长度；遍历数组占用 O(N) ，每轮中的常数个位运算操作占用  O(1)O(32×3×2)=O(1) 。
    //空间复杂度 O(1) ： 变量 ones , twos 使用常数大小的额外空间。
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
