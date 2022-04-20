package swordtooffer;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
public class P29_顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0;//左边界
        int r = matrix[0].length - 1;//右边界
        int t = 0;//上边界
        int b = matrix.length - 1;//下边界
        int[] res = new int[(r + 1) * (b + 1)];
        int index = 0;
        while (true) {
            //从左向右
            for (int j = l; j <= r; j++) {
                res[index++] = matrix[t][j];
            }
            if (++t > b) {
                break;
            }
            //从上到下
            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            //从右至左
            for (int j = r; j >= l; j--) {
                res[index++] = matrix[b][j];
            }
            if (--b < t) {
                break;
            }
            //从下至上
            for (int i = b; i >= t; i--) {
                res[index++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}
