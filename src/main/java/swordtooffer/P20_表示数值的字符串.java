package swordtooffer;

import java.util.HashMap;
import java.util.Map;
//本题使用有限状态自动机。根据字符类型和合法数值的特点，先定义状态，再画出状态转移图，最后编写代码即可。
public class P20_表示数值的字符串 {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},//0
                new HashMap() {{
                    put('d', 2);
                    put('.', 4);
                }},//1
                new HashMap() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},//2
                new HashMap() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},//3
                new HashMap() {{
                    put('d', 3);
                }},//4
                new HashMap() {{
                    put('s', 6);
                    put('d', 7);
                }},//5
                new HashMap() {{
                    put('d', 7);
                }},//6
                new HashMap() {{
                    put('d', 7);
                    put(' ', 8);
                }},//7
                new HashMap() {{
                    put(' ', 8);
                }}//8
        };
        char[] chars = s.toCharArray();
        int p = 0;
        char t;
        for (char c :
                chars) {
            if (c >= '0' && c <= '9') t = 'd';//数字
            else if (c == '+' || c == '-') t = 's';//标志位
            else if (c == 'e' || c == 'E') t = 'e';//幂
            else if (c == ' ' || c == '.') t = c;
            else t = '?';//表示未知
            if (!states[p].containsKey(t)) return false;//表示无法转移状态
            p = (int) states[p].get(t);
        }
        // 跳出循环后，若状态 p in {2, 3, 7, 8} ，说明结尾合法，返回 True，否则返回 False
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
