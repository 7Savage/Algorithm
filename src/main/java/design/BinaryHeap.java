package design;


import java.util.PriorityQueue;

public class BinaryHeap {
    /*
    中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4]的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-median-from-data-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class MedianFinder {


        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;

        public MedianFinder() {
            large= new PriorityQueue<>();//小顶堆，根节点的值最大
            small = new PriorityQueue<>((a, b) -> b - a);//大顶堆，根节点的值最小
        }

        // 添加一个数字
        public void addNum(int num) {
            if (large.size() >= small.size()) {
                large.add(num);
                small.add(large.poll());
            } else {
                small.add(num);
                large.add(small.poll());
            }
        }

        // 计算当前添加的所有数字的中位数
        public double findMedian() {
            if (large.size() > small.size()) {
                return large.peek();
            } else if (large.size() < small.size()) {
                return small.peek();
            } else {
                return (large.peek() + small.peek()) / 2.0;
            }
        }
    }
}
