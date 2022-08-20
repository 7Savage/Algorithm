package 笔试.科大讯飞;

import java.util.ArrayList;

public class Main3 {
    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<Point> res;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param maze int整型二维数组 迷宫数据 固定为4x4的二维数组，0表示路，可走；1 表示墙，不可通过； 8 表示礼物，是我们的目标
     * @return Point类ArrayList
     */
    public ArrayList<Point> winMazeGift(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;

        for (int i = 0; i < m; i++) {
            if (maze[i][0] == 0) {
                dfs(maze, i, 0, new ArrayList<>());
            }
            if (maze[i][n - 1] == 0) {
                dfs(maze, i, n - 1, new ArrayList<>());
            }
        }
        for (int j = 0; j < n; j++) {
            if (maze[0][j] == 0) {
                dfs(maze, 0, j, new ArrayList<>());
            }
            if (maze[m - 1][j] == 0) {
                dfs(maze, m - 1, j, new ArrayList<>());
            }
        }
        return res;
        // write code here
    }

    public void dfs(int[][] maze, int i, int j, ArrayList<Point> list) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length || maze[i][j] == 1) {
            return;
        }
        Point point = new Point(i, j);
        list.add(point);
        if (maze[i][j] == 8) {
            if (res == null) {
                res = new ArrayList<>(list);
            }
            if (list.size() < res.size()) {
                res = new ArrayList<>(list);
            }
            return;
        }
        maze[i][j] = 1;
        dfs(maze, i - 1, j, list);
        dfs(maze, i + 1, j, list);
        dfs(maze, i, j - 1, list);
        dfs(maze, i, j + 1, list);
        maze[i][j] = 0;
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        int[][] maze = {{0, 1, 1, 1}, {0, 0, 0, 1}, {1, 0, 8, 1}, {1, 0, 1, 1}};
        ArrayList<Point> points = main3.winMazeGift(maze);
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            System.out.println(point.x + "，" + point.y);
        }

    }
}
