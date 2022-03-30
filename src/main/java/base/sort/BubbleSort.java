package base.sort;

import java.util.Arrays;

/**
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3. 针对所有的元素重复以上的步骤，除了最后一个；
 * 4. 重复步骤1~3，直到排序完成。
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        int temp;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
