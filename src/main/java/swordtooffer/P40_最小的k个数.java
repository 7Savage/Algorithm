package swordtooffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
public class P40_最小的k个数 {
    //时间复杂度 O(N),哨兵划分操作一共有 N+N/2+N/4+....=2N-1次
    //空间复杂度 O(1)
    //本方法优化时间复杂度的本质是通过判断舍去了不必要的递归
    public int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quicksort(int[] arr, int left, int right, int k) {
        if (left < right) {
            int mid = partition(arr, left, right);
            if (k < mid) {
                quicksort(arr, left, mid - 1, k);
            } else if (k > mid) {
                quicksort(arr, mid + 1, right, k);
            }
        }
    }

    public int partition(int[] num, int left, int right) {
        int pivot = num[left];
        while (left < right) {
            while (left < right && num[right] >= pivot) {
                right--;
            }
            num[left] = num[right];
            while (left < right && num[left] <= pivot) {
                left++;
            }
            num[right] = num[left];
        }
        num[left] = pivot;
        return left;
    }

    //时间复杂度：O(NlogK)
    //空间复杂度：O(K)
    //大顶堆：每个结点的值都大于或等于其左右孩子结点的值
    //小顶堆：每个结点的值都小于或等于其左右孩子结点的值
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        //建立一个大顶堆，优先队列默认时小顶堆
        //大顶堆的堆顶元素时最小的
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (m, n) -> (n - m));
        for (int i = 0; i < arr.length; i++) {
            //堆空||堆内元素个数小于k||待添加的元素值小于大顶堆的最大值
            if (pq.isEmpty() || pq.size() < k || arr[i] < pq.peek()) {
                pq.add(arr[i]);
            }
            //堆内元素个数大于k，就弹出最大的那一个
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        for (int e :
                pq) {
            res[i++] = e;
        }
        return res;
    }


    @Test
    public void test() {
        int[] arr = {3, 2, 1, 4, 7, 8};
        int[] leastNumbers = getLeastNumbers(arr, 5);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
