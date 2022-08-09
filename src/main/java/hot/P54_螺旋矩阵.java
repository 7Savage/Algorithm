package hot;

import java.util.ArrayList;
import java.util.List;

public class P54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int len = (bottom + 1 ) * (right + 1);
        int k = 0;
        while (true) {
            for(int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            if (++top > bottom) {
                break;
            }
            for(int i= top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
