package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P406_根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });

        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
