package 笔试.zoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> heads[];
    static char[] c;
    static int[] val;
    static boolean[] flag;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        c=(" "+scanner.next()).toCharArray();
        val =new  int[n+1];
        flag=new boolean[n+1];
        heads=new ArrayList[n+1];
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt(),v=scanner.nextInt();
            if(heads[u]==null){
                ArrayList<Integer> t=new ArrayList<>();
                heads[u]=t;
            }
            if(heads[v]==null){
                ArrayList<Integer> t =new ArrayList<>();
                heads[v]=t;
            }
            heads[u].add(v);
            heads[v].add(u);
        }

        int rSum=0;
        int bSum=0;
        dfs(1,0,0);
        int ans=0;
        for (int v:
             val) {
            ans+=v;
        }
        System.out.println(ans);

    }

    private static void dfs(int idx, int rc, int bc) {
        flag[idx]=true;
        if(c[idx]=='R'){
            rc++;
        }else{
            bc++;
        }
        val[idx]=Math.abs(rc-bc);
        for (Integer i:
             heads[idx]) {
            if(!flag[i]){
                dfs(i,rc,bc);
            }
        }
    }
}

