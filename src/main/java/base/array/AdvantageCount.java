package base.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount {
    /**
     * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
     * <p>
     * 返回 A 的任意排列，使其相对于 B 的优势最大化。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //从大到小排序的优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] pair1, int[] pair2) -> pair2[1] - pair1[1]);
        for (int i = 0; i < nums2.length; i++) {
            pq.add(new int[]{i, nums2[i]});
        }
        int n = nums1.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        //将nums1从下到大排序
        Arrays.sort(nums1);
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int index = pair[0];
            int value = pair[1];
            //如果拿nums1中最大的去比nums2最大的，还大，就比
            if (nums1[right] > value) {
                res[index] = nums1[right];
                right--;
            } else {
                //否则就用最小的当替死鬼
                res[index] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
