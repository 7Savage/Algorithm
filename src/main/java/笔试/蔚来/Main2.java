package 笔试.蔚来;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static int N = 10005;
    static long Max = (long)1e12 + 2;
    static int USE = 30;

    static List<Long> list;
    static int ans;

    public static void dfs(long money, int cur,int used) {
        long now = list.get(cur);
        if ((USE -used)*now<money) {
            return;
        }
        if(money%now ==0) {
            int ansTemp = (int)(money/now)+used;
            if (ansTemp <ans) {
                ans = ansTemp;
            }
            return;
        }
        int papers = (int)(money/now);
        for (int i = papers; i >= 0; i--) {
            dfs(money- i*now, cur-1, used + i);
        }
    }

    public static void main(String[] args) {
        list = new ArrayList<>();
        for (long i = 1;i <Max; i*=6) {
            list.add(i);
        }

        for(long i = 1;i <Max;i*=9) {
            list.add(i);
        }
        list.sort(Long::compareTo);
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            ans = 0x3f3f3f3f;
            dfs(scanner.nextLong(),list.size()-1,0);
            System.out.println(ans);
        }
    }
}
