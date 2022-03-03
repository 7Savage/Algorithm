package swordtooffer;

import java.util.HashMap;
import java.util.Map;

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
}
