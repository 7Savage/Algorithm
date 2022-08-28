package 笔试.京东;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        long res = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int maxA = 0, maxB = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            } else {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            }
        }
        int maxValueA = 0;
        for (int key :
                map1.keySet()) {
            int valueA = map1.get(key);
            if (valueA > maxValueA) {
                maxValueA = valueA;
                maxA = key;
            }
        }
        int maxValueB = 0;
        for (int key :
                map2.keySet()) {
            int valueB = map2.get(key);
            if (valueB > maxValueB) {
                maxValueB = valueB;
                maxB = key;
            }
        }
        int tmpA = maxA;
        int tmpB = maxB;
        if (maxA == maxB) {
            map1.remove(maxA);
            map2.remove(maxB);
            maxValueA = 0;
            maxValueB = 0;
            for (int key :
                    map1.keySet()) {
                int valueA = map1.get(key);
                if (valueA > maxValueA) {
                    maxValueA = valueA;
                    maxA = key;
                }
            }
            for (int key :
                    map2.keySet()) {
                int valueB = map2.get(key);
                if (valueB > maxValueB) {
                    maxValueB = valueB;
                    maxB = key;
                }
            }
            if (maxValueA > maxValueB) {
                maxB = tmpB;
            } else {
                maxA = tmpA;
            }
        }


        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                if (maxA != nums[i]) {
                    res++;
                }
            } else {
                if (maxB != nums[i]) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
