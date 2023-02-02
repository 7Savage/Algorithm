package 面试.华为;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述 给你一个数学表达式，请你求出它的值。
 * 表达式中可能含有以下运算符：”+”、”-“、”*“、”/“、”(“、”)”，
 * 其中优先级为: 括号 > “*” = “/“ > “+” = “-“。
 * 解答要求 时间限制：1000ms, 内存限制：100MB
 * 输入 输入文件包含一行，字符之间用空格分开，
 * 所有的数字为小于10的正整数,表达式中的字符数目不超过1000，以$为结束符号;
 * 输出 输出一个整数，表示该表达式的值，结果小于2^31。
 * 样例 ( 2 + 1 ) * 3 $ 输出样例 1  9
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '$') {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(func2(sb.toString()));

    }

    public static int func1(String str) {
        LinkedList<Integer> stack = new LinkedList<>();
        int sign = 1;
        int n = str.length();
        int i = 0;
        int res = 0;
        while (i < n - 1) {
            if (str.charAt(i) == ' ') {
                i++;
            } else if (str.charAt(i) == '+') {
                sign = stack.peek();
                i++;
            } else if (str.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
            } else if (str.charAt(i) == '(') {
                stack.push(sign);
                i++;
            } else if (str.charAt(i) == ')') {
                stack.pop();
                i++;
            } else if (str.charAt(i) == '*') {

            }
        }
        return 3;
    }

    public static int func2(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
