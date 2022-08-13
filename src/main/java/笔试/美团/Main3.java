package 笔试.美团;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        Queue<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            index.add(i);
        }
        int[] res = new int[n];
        int num = 0;
        while (!index.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                int temp = index.peek();
                index.poll();
                index.add(temp);
            }
            res[index.peek()] = data[num];
            num++;
            index.poll();
        }
        for (int x :
                res) {
            System.out.println(x + " ");
        }

    }
}
