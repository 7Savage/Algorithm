package swordtooffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

//根据题意，此 55 张牌是顺子的 充分条件 如下：
//
//1.除大小王外，所有牌 无重复 ；
//2.设此 5 张牌中最大的牌为 max ，最小的牌为 min（大小王除外），则需满足：max - min < 5
public class P61_扑克牌中的顺子 {
    //时间复杂度 O(N)
    //空间复杂度 O(N)
    public boolean isStraight(int[] nums) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
            set.add(num);
        }
        return max - min < 5;
    }
}
