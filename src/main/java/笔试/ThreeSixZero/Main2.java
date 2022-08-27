package 笔试.ThreeSixZero;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        for (int i = 0; i < k; i++) {
            int target = scanner.nextInt();
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (nums[j] == target) {
                    index = j;
                    break;
                }
            }
            partition(nums, 0, nums.length - 1, index);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int partition(int[] nums, int left, int right, int index) {
        int pivot = nums[index];
        while (left < index && right > index) {
            while (right > index && nums[right] >= pivot) right--;
            nums[index] = nums[right];
            while (left < index && nums[left] <= pivot) left++;
            nums[right] = nums[index];
        }
        nums[index] = pivot;
        return left;
    }
}
