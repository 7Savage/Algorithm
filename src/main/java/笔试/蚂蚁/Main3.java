package 笔试.蚂蚁;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = str.length();
        char[] chars = str.toCharArray();
        int res = 0;
        int count = 0;
        int[] nums = new int[26];
        for (int i = 0; i < n; i++) {
            nums[chars[i] - 'a']++;
            count++;
            for (int j = i; j < n; j++) {
                if (j == i) {
                    res++;
                } else {
                    nums[chars[j] - 'a']++;
                    if (nums[chars[j] - 'a'] % 2 == 1) {
                        count++;
                    } else {
                        count--;
                    }

                    if (count == 1) {
                        res++;
                    }
                }
                if (j == n - 1) {
                    count = 0;
                    nums = new int[26];
                }
            }
        }
        System.out.println(res);
    }
}
