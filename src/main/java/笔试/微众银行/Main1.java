package 笔试.微众银行;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.next();
        }

        Arrays.sort(nums, (o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            if (len1 != len2) {
                return len1 - len2;
            }else{
                for (int i = 0; i < len1; i++) {
                    char cur1 = o1.charAt(i);
                    char cur2 = o2.charAt(i);
                    if (cur1 != cur2) {
                        return cur1 - cur2;
                    }
                }
            }
            return 0;
        });

        String[] strs = new String[3];
        strs[0] = nums[n - 1];
        strs[1] = nums[n - 2];
        strs[2] = nums[n - 3];


        Arrays.sort(strs, (o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            int minLen = Math.min(len1, len2);
            for (int i = 0; i < minLen; i++) {
                char cur1 = o1.charAt(i);
                char cur2 = o2.charAt(i);
                if (cur1 != cur2) {
                    return cur1 - cur2;
                }
            }
            if (len1 == len2) {
                return 0;
            }else{
                if (len1 - minLen > 0) {
                    return o1.charAt(minLen) - o1.charAt(0);
                } else {
                    return o2.charAt(minLen) - o2.charAt(0);
                }
            }
        });

        StringBuilder res = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            res.append(strs[i]);
        }
        System.out.println(res);
    }


}
