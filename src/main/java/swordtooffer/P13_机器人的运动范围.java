package swordtooffer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class P13_机器人的运动范围 {
    int m, n, k;
    boolean[][] visited;

    //时间复杂度 O(MN)
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || (si + sj) > k || visited[i][j]) {
            return 0;
        }
        //是否访问过
        visited[i][j] = true;
        //只能向下或向右，si sj的位和要注意
        return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj) + dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1);
    }
}
