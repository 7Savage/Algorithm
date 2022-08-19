package base.dp.路径;

public class P64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j -1]);
            }
        }
        return grid[row - 1][col - 1];

    }
}
