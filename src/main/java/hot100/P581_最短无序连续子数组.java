package hot100;

import java.util.Arrays;
import java.util.Stack;

public class P581_最短无序连续子数组 {

    //排序，时间复杂度：O(nlogn)，空间复杂度：O(n)
    public int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int start = nums.length, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (clone[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }

    //栈，时间复杂度：O(n)，空间复杂度：O(n)
    public int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                start = Math.min(start, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }
        return end >= start ? end - start + 1 : 0;
    }

    //时间复杂度：O(n)，空间复杂度：O（1）
    public int findUnsortedSubarray3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i - 1]);
            }
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < nums.length) {
            if (nums[start] > min) {
                break;
            }
            start++;
        }
        while (end >= 0) {
            if (nums[end] < max) {
                break;
            }
            end--;
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }


}
