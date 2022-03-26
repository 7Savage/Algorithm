package base.tree.bfs;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();//访问集合
        Queue<String> queue = new LinkedList<>();//每一层代表拨动一次转表
        //死亡数字集合
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        visited.add("0000");
        queue.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (dead.contains(str)) {
                    continue;
                }
                if (str.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(str, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    String down = minusOne(str, j);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String minusOne(String str, int j) {
        char[] chars = str.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j]--;
        }
        return new String(chars);
    }

    private String plusOne(String str, int j) {
        char[] chars = str.toCharArray();

        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j]++;
        }
        return new String(chars);
    }
}
