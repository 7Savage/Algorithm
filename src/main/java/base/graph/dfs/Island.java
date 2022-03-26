package base.graph.dfs;

import base.tree.TreeNode;

public class Island {
    //二叉树遍历框架
    public void traverse(TreeNode root) {
        traverse(root.left);
        traverse(root.right);
    }

    //二维矩阵遍历框架
    public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            //超出索引边界
            return;
        }
        if (visited[i][j]) {
            //已经遍历过(i,j)
            return;
        }
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);//向上遍历
        dfs(grid, i + 1, j, visited);//向下遍历
        dfs(grid, i, j + 1, visited);//向左遍历
        dfs(grid, i, j + 1, visited);//向右遍历
    }


    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //计算岛没有被淹没
                if (grid[i][j] == '1') {
                    res++;
                    //将周围的岛淹没
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        //将此左边淹没
        grid[i][j] = '0';
        //将周围的坐标淹没
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 二维矩阵 grid由 0（土地）和 1（水）组成。岛是由最大的4个方向连通的 0组成的群，封闭岛是一个完全 由1包围（左、上、右、下）的岛。
     * <p>
     * 请返回 封闭岛屿 的数目。
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        //将最上和最下边的岛屿淹没
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        //将最左和最右的岛屿淹没
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                }
                //淹没周围的岛屿
                dfs(grid, i, j);
            }
        }

        return res;

    }

    public void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
     * <p>
     * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
     * <p>
     * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
     *
     * @param grid
     * @return
     */


    public int numEnclaves(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        //淹没左右边界的岛
        for (int i = 0; i < m; i++) {
            dfs2(grid, i, 0);
            dfs2(grid, i, n - 1);
        }
        //淹没上下边界的岛
        for (int j = 0; j < n; j++) {
            dfs2(grid, 0, j);
            dfs2(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    res++;
            }
        }
        return res;

    }

    public void dfs2(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        //如果被淹没，则返回
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs2(grid, i - 1, j);
        dfs2(grid, i + 1, j);
        dfs2(grid, i, j - 1);
        dfs2(grid, i, j + 1);
    }

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     * <p>
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * <p>
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     * <p>
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs3(grid, i, j));
                }
            }
        }
        return res;

    }

    private int dfs3(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        //如果被淹没，则返回
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return dfs3(grid, i - 1, j) +
                dfs3(grid, i + 1, j) +
                dfs3(grid, i, j - 1) +
                dfs3(grid, i, j + 1) + 1;
    }


    /**
     * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
     * <p>
     * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
     * <p>
     * 请你返回 grid2 中 子岛屿 的 数目 。
     *
     * @param grid1
     * @param grid2
     * @return
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果左岛屿是水域并且右岛屿是陆地
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    //淹没该水域及其邻接陆地，因为题目要求是完全包含
                    dfs4(grid2, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs4(grid2, i, j);
                }
            }
        }
        return res;
    }

    public void dfs4(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs4(grid, i - 1, j);
        dfs4(grid, i + 1, j);
        dfs4(grid, i, j - 1);
        dfs4(grid, i, j + 1);
    }


}
