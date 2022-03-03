package hot100;

import java.util.Arrays;

public class P621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for (char task : tasks) {
            bucket[task - 'A']++;
        }
        Arrays.sort(bucket);
        int maxCount = 1;
        int maxTimes = bucket[25];
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] == bucket[i - 1]) {
                maxCount++;
            } else {
                break;
            }
        }
        return Math.max(tasks.length, (maxTimes - 1) * (n + 1) + maxCount);
    }
}
