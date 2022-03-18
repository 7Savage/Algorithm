package base.backtrack;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(new StringBuilder(), n, n);
        return res;
    }

    public void backTrack(StringBuilder sb, int left, int right) {
        // 若左括号剩下的多，说明不合法
        if (left > right) {
            return;
        }
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) {
            return;
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        // 尝试放一个左括号
        sb.append("(");
        backTrack(sb, left - 1, right);// 选择
        sb.deleteCharAt(sb.length() - 1);// 撤消选择
        // 尝试放一个右括号
        sb.append(")");
        backTrack(sb, left, right - 1);// 选择
        sb.deleteCharAt(sb.length() - 1);// 撤消选择
    }
}
