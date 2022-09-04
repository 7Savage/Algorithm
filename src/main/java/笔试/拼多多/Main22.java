package 笔试.拼多多;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] moves = new int[n];
            for (int i = 0; i < n; i++) {
                String sym = scanner.next();
                if (sym.equals("L")) {
                    moves[i] = -scanner.nextInt();
                } else {
                    moves[i] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                int curr = i;
                Set<Integer> set = new HashSet<>();
                set.add(curr);
                int step = 0;
                while (true) {
                    curr += moves[curr];
                    step++;
                    if (curr < 0 || curr >= n) {
                        System.out.print(step + " ");
                        break;
                    }
                    if (set.contains(curr)) {
                        System.out.print(-1 + " ");
                        break;
                    } else {
                        set.add(curr);
                    }
                }
            }
            System.out.println("");
        }

    }
}
