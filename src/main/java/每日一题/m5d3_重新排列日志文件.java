package 每日一题;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class m5d3_重新排列日志文件 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] s1 = o1.split(" ", 2);//分成两份
            String[] s2 = o2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            //都是字母日志
            if (!isDigit1 && !isDigit2) {
                int cmp = s1[1].compareTo(s2[1]);
                if (cmp != 0) {
                    return cmp;
                } else {
                    return s1[0].compareTo(s2[0]);
                }
            }
            //都是数字日志
            if (isDigit1 && isDigit2) {
                return 0;
            }
            //s1为字母日志，s2为数字日志,大于0就是从小到大排序
            if (!isDigit1 && isDigit2) {
                return 1;
            }
            //s1为数字日志，s2为字母日志，小于0就是从大到小排序
            if (isDigit1 && !isDigit2) {
                return -1;
            }
            return 1;
        });
        return logs;
    }

    @Test
    public void test() {
        String s1 = "abc dwi dwai 332 iss9 323";
        String[] s = s1.split(" ", 2);
        System.out.println(Arrays.toString(s));
    }
}
