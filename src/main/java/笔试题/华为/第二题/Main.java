package 笔试题.华为.第二题;

import java.util.*;

public class Main {
    static int m,n;
    static int[][] map;
    static int[] start;
    static int[] end;
    static int mindis = Integer.MAX_VALUE;
    static int count = 0;
    static int[][] turn = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        map = new int[m][n];
        start = new int[3];
        start[0] = scanner.nextInt();
        start[1] = scanner.nextInt();
        start[2] = 0;
        end = new int[3];
        end[0] = scanner.nextInt();
        end[1] = scanner.nextInt();
        end[2] = 0;
        int k = scanner.nextInt();
        for(int i = 0;i<k;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x][y] = -1;
        }
        BFS();
        System.out.print(count);
        System.out.print(' ');
        System.out.print(mindis);
    }
    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int step = cur[2];
            if(x == end[0] && y == end[1]){
                if(step < mindis){
                    mindis = step;
                    count = 1;
                }
                else if(step == mindis){
                    count ++;
                }
                continue;
            }
            map[x][y] = 1;
            if(step >= mindis) continue;
            for(int i=0;i<4;i++){
                int next_x = x + turn[i][0];
                int next_y = y + turn[i][1];
                int next_step = step + 1;
                if(next_x>=0 && next_x<m && next_y>=0 && next_y<n && map[next_x][next_y]==0){
                    queue.add(new int[]{next_x,next_y,next_step});
                }
            }
        }
    }
}
