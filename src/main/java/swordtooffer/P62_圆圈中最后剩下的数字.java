package swordtooffer;

import java.util.ArrayList;
import java.util.List;

public class P62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
