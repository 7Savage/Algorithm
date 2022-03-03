package hot100;

import java.util.Stack;

public class P394_字符串解码 {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> multiStack = new Stack<>();
        for (char c : chars) {
            if (c == '[') {
                stringStack.push(res.toString());
                multiStack.push(multi);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer currentMulti = multiStack.pop();
                for (int i = 0; i < currentMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stringStack.pop()).append(tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
