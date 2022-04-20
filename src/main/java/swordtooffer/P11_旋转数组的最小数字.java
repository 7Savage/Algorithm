package swordtooffer;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 */
public class P11_旋转数组的最小数字 {
    //二分
    //时间复杂度 O(logN)
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                //注意，跟模板有出入
                //说明在右排序数组中，要把刚刚的mid算进去，因为旋转点肯定在右排序数组中
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                //经验证，注意
                right = right - 1;
            }
        }
        return numbers[left];
    }
}
