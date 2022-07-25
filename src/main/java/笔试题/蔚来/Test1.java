package 笔试题.蔚来;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            String str = scanner.next();
            char[] chars = str.toCharArray();
            int count=0;
            for (int i = 0; i < chars.length; i++) {
                if(!Character.isDigit(chars[i])){
                    continue;
                }else{
                    count++;
                }
            }
        }
    }
}
