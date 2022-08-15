package 笔试.微软;

import java.util.Arrays;
import java.util.PriorityQueue;

//第一题：将A中的某个数字减少一半，最少需要多少次后，数组的和小于等于原来数组和的一半
// 思路：贪心，大根堆
public class Main1 {
    // 第一题：将A中的某个数字减少一半，最少需要多少次后，数组的和小于等于原来数组和的一半
    // 思路：贪心，大根堆
    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> (int) (b - a));
        int sum = 0;
        for (int n : A) {
            sum += n;
            heap.offer((double) n);
        }
        int res = 0;
        double reduce = 0;
        while (reduce * 2 < sum) {
            double cur = heap.poll();
            cur /= 2;
            reduce += cur;
            heap.offer(cur);
            res++;
        }
        return res;
    }
}
