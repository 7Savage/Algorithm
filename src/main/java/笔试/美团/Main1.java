package 笔试.美团;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        boolean flag = true;
        int now = t;
        while (flag) {
            flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= now) {
                    flag = true;
                    list.remove(i);
                    now += t;
                    break;
                }
            }
        }
        System.out.println(list.size());
    }
}
