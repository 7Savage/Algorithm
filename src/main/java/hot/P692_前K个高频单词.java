package hot;

import java.util.*;

public class P692_前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b.compareTo(a);
            } else {
                return map.get(a) - map.get(b);
            }
        });

        for (String word : map.keySet()) {
            queue.add(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        Collections.reverse(res);

        return res;
    }
}
