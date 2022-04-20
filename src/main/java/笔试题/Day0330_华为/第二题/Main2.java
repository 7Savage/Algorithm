package 笔试题.Day0330_华为.第二题;

import java.util.Scanner;

public class Main2 {
    public static int minlen = Integer.MAX_VALUE;
    public static int[][] map;
    public static int[][] pool;
    public static int num_path = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int hang = scan.nextInt();
        int lie = scan.nextInt();
        map = new int[hang][lie];
        int startx = scan.nextInt();
        int starty = scan.nextInt();
        int endx = scan.nextInt();
        int endy = scan.nextInt();
        int num = scan.nextInt();
        int[][] pool = new int[num][2];
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < num; i++) {
            pool[i][0] = scan.nextInt();
            pool[i][1] = scan.nextInt();
            map[pool[i][0]][pool[i][1]] = -1;   //有湖标记为-1;
        }


        dfs(0, startx, starty, endx, endy);
        System.out.println(num_path + " " + minlen);
    }


    //剪枝还没剪就结束了
    public static void dfs(int cur_len, int startx, int starty,
                           int endx, int endy) {
        if (startx < 0 || startx > map.length - 1 || starty < 0 || starty > map[0].length - 1
                || map[startx][starty] != 0)
            return; //越界或者走过了或者为湖则返回
        if (startx == endx && starty == endy) {
            if (cur_len < minlen) {
                num_path = 1;
                minlen = cur_len;
            } else if (cur_len == minlen) {
                num_path++;
            }
            return;   //走到终点了
        } else {
            map[startx][starty] = 1;
            dfs(cur_len + 1, startx + 1, starty, endx, endy);
            dfs(cur_len + 1, startx - 1, starty, endx, endy);
            dfs(cur_len + 1, startx, starty + 1, endx, endy);
            dfs(cur_len + 1, startx, starty - 1, endx, endy);
            map[startx][starty] = 0;
        }
    }


}
