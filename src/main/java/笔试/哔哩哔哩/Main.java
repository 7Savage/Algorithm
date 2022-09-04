package 笔试.哔哩哔哩;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 1) {
            System.out.println(n);
        }
        System.out.println(getMin(n));
    }

    public static int getMin(int n) {
        int temp = n / 2;
        while (temp != 0) {
            if (n % temp == 0) {
                if (temp == 1) {
                    return n;
                } else {
                    return getMin(n / temp) + getMin(temp);
                }
            } else {
                temp -= 1;
            }
        }
        return 0;
    }
}
