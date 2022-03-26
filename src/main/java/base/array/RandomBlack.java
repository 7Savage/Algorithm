package base.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 */
public class RandomBlack {
    Map<Integer, Integer> map;
    int sz;

    public RandomBlack(int n, int[] blacklist) {
        map = new HashMap<>();
        for (int i = 0; i < blacklist.length; i++) {
            map.put(blacklist[i], -1);
        }
        sz = n - blacklist.length;
        int last = n - 1;
        for (int i = 0; i < blacklist.length; i++) {
            if (blacklist[i] >= sz) {
                continue;
            }
            while (map.containsKey(last)) {
                last--;
            }
            map.put(blacklist[i], last);
            last--;
        }
    }

    public int pick() {
        Random random = new Random();
        int index = random.nextInt(sz);
        if (map.containsKey(index)) {
            return map.get(index);
        } else {
            return index;
        }
    }
}
