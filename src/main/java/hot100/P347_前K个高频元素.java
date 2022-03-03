package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (priorityQueue.size() == k) {
                if (count > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num, count});
                }
            } else {
                priorityQueue.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }
}
