package swordtooffer;

//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
public class P45_把数组排成最小的数 {
    StringBuilder sb = new StringBuilder();

    //时间复杂度 O(NlogN) ： N 为最终返回值的字符数量（ str列表的长度 ≤N ）；使用快排或内置函数的平均时间复杂度为 O(NlogN) ，最差为 O(N^2)
    //空间复杂度 O(N) ： 字符串列表 str 占用线性大小的额外空间
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str, 0, str.length - 1);
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void quickSort(String[] str, int left, int right) {
        if (left < right) {
            int mid = partition(str, left, right);
            quickSort(str, left, mid - 1);
            quickSort(str, mid + 1, right);
        }
    }

    //x “小于” y 代表：排序完成后，数组中 x 应在 y 左边；“大于” 则反之。
    //数学证明略
    private int partition(String[] str, int left, int right) {
        String pivot = str[left];
        while (left < right) {
            while (left < right && ((str[right] + pivot).compareTo(pivot + str[right]) >= 0)) {
                right--;
            }
            str[left] = str[right];
            while (left < right && ((str[left] + pivot).compareTo(pivot + str[left]) <= 0)) {
                left++;
            }
            str[right] = str[left];
        }
        str[left] = pivot;
        return left;
    }


}
