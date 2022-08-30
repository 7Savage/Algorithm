package 笔试.荣耀;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    static int res = Integer.MAX_VALUE;
    static LinkedList<int[]> track = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] nums = new int[5][2];
        boolean[] used = new boolean[5];
        for (int i = 0; i < 5; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        backtrack(nums, used);
        System.out.println(res);
    }

    public static double dis(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static void backtrack(int[][] nums, boolean[] used) {
        if (track.size() == 5) {
            double start = dis(0, 0, track.get(0)[0], track.get(0)[1]);
            double mid = 0;
            for (int i = 1; i < track.size(); i++) {
                int x1 = track.get(i - 1)[0];
                int y1 = track.get(i - 1)[1];
                int x2 = track.get(i)[0];
                int y2 = track.get(i)[1];
                mid += dis(x1, y1, x2, y2);
            }
            double end = dis(0, 0, track.getLast()[0], track.getLast()[1]);
            int sum = (int) (start + mid + end);
            res = Math.min(res, sum);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }
}

