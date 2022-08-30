package 笔试.荣耀;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int BtoK = 1024;
        int KtoM = 1024 ^ 2;
        long MtoG = 1024 ^ 3;
        float num;
        String res;
        float temp = Float.parseFloat(String.valueOf(n));
        if (n < BtoK) {
            res = String.format("%.2f", temp) + "B";
        } else if (n < KtoM) {
            float bk = Float.parseFloat(String.valueOf(BtoK));
            num = temp / bk;
            res = String.format("%.2f", num) + "KB";
        } else if (n < MtoG) {
            float km = Float.parseFloat(String.valueOf(KtoM));
            num = temp / km;
            res = String.format("%.2f", num) + "MB";
        } else {
            float mg = Float.parseFloat(String.valueOf(MtoG));
            num = temp / mg;
            res = String.format("%.2f", num) + "GB";
        }
        System.out.println(res);
    }
}
