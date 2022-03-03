package swordtooffer;

public class P45_把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        quickSort(res, 0, res.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String re : res) {
            sb.append(re);
        }
        return sb.toString();
    }

    public void quickSort(String[] str, int low, int high) {
        if (low >= high)
            return;

        int i = low, j = high;
        while (i < j) {
            while ((str[low] + str[j]).compareTo(str[j] + str[low]) <= 0 && i < j) {
                j--;
            }
            while ((str[low] + str[i]).compareTo(str[i] + str[low]) >= 0 && i < j) {
                i++;
            }
            swap(str, i, j);
        }

        swap(str, low, j);
        quickSort(str, low, j - 1);
        quickSort(str, j + 1, high);
    }

    public void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
