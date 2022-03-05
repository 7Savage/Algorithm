package base.array;

import java.util.ArrayList;
import java.util.List;

public class Traverse {
    /**
     * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
     * <p>
     * 时间复杂度：O(n)，其中 n 为输入字符串的长度。
     * 空间复杂度：Java 和 Python 的方法需要 O(n) 的空间来存储字符串，而 C++ 方法只需要O(1) 的额外空间来存放若干变量。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
                //去除多余的空格，只保留一个
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * <p>
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * <p>
     * 我们可以先将 n x n 矩阵 matrix 按照左上到右下的对角线进行镜像对称
     * 然后再对矩阵的每一行进行反转：
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //主对角线镜像变换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //横向变化
        for (int[] row :
                matrix) {
            reverse(row);
        }
    }

    private void reverse(int[] row) {
        int i = 0;
        int j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = col - 1;
        int t = 0;
        int b = row - 1;
        int target = row * col;
        List<Integer> res = new ArrayList<>();
        int num = 1;
        while (num <= target) {
            for (int i = l; i <= r && num <= target; i++) {
                res.add(matrix[t][i]);
                num++;
            }
            t++;
            for (int i = t; i <= b && num <= target; i++) {
                res.add(matrix[i][r]);
                num++;
            }
            r--;
            for (int i = r; i >= l && num <= target; i--) {
                res.add(matrix[b][i]);
                num++;
            }
            b--;
            for (int i = b; i >= t && num <= target; i--) {
                res.add(matrix[i][l]);
                num++;
            }
            l++;
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int target = n * n;
        int[][] res = new int[n][n];
        int num = 1;
        while (num <= target) {
            for (int i = l; i <= r; i++) res[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) res[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) res[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) res[i][l] = num++;
            l++;
        }
        return res;
    }
}
