package base.tree.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        String target = "123450";
        int step = 0;
        StringBuilder sb = new StringBuilder();
        //将二维数组转化为一维
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        //记录邻居索引
        int[][] neighbour = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                //记录0的位置
                int index0 = -1;
                for (int j = 0; j < 6; j++) {
                    if (cur.charAt(j) == '0') {
                        index0 = j;
                        break;
                    }
                }
                //交换邻居，在不重复的情况下
                for (int neigh :
                        neighbour[index0]) {
                    String newString = swap(cur.toCharArray(), index0, neigh);
                    if (!visited.contains(newString)) {
                        queue.add(newString);
                        visited.add(newString);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(char[] chars, int index0, int neigh) {
        char temp = chars[index0];
        chars[index0] = chars[neigh];
        chars[neigh] = temp;
        return new String(chars);
    }
}
