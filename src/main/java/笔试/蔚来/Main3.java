package 笔试.蔚来;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3{

    static HashMap<String,List<Integer>> memo = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String input) {

        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '-' || c == '*' || c == '+') {
                List<Integer>
                        left = diffWaysToCompute(input.substring(0, i));
                List<Integer>
                        right = diffWaysToCompute(input.substring(i + 1));
                for (int a : left)
                    for (int b : right)
                        if (c == '+')
                            res.add(a + b);
                        else if (c == '-')
                            res.add(a - b);
                        else if (c == '*')
                            res.add(a * b);
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }

        memo.put(input, res);
        return res;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        List<Integer> res = diffWaysToCompute(str);
        System.out.println(res);
    }
}

