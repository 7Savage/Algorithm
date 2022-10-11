package 笔试.华为;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            orders[i][0] = scanner.nextInt();
            orders[i][1] = scanner.nextInt();
        }

        Arrays.sort(orders, (o1, o2) -> (o1[1]-o2[1]));

        int currTime = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (currTime + orders[i][0] <= orders[i][1]) {
                res++;
                currTime += orders[i][0];
            }
        }
        System.out.println(res);
    }
}
