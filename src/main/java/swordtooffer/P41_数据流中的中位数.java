package swordtooffer;

import java.util.PriorityQueue;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
public class P41_数据流中的中位数 {
    class MedianFinder {
        PriorityQueue<Integer> A;//大顶堆
        PriorityQueue<Integer> B;//小顶堆

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            A = new PriorityQueue<>((a, b) -> (b - a));
            B = new PriorityQueue<>();
        }

        //添加数字 O(logN)
        public void addNum(int num) {
            int m = A.size();
            int n = B.size();
            //奇数的情况
            if (m != n) {
                A.add(num);
                B.add(A.poll());
            }
            //偶数的情况
            else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            int m = A.size();
            int n = B.size();
            if (m == n) {
                return (A.peek() + B.peek()) / 2.0;
            } else {
                return A.peek();
            }
        }
    }
}
