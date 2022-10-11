package 笔试.华为;

import java.util.Scanner;

public class Main3 {
    static int[] root;
    static int[] child;
    static int[] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String l1 = scanner.nextLine().replace("[", "").replace("]", "");
        String l2 = scanner.nextLine();
        String l3 = scanner.nextLine().replace("[", "").replace("]", "");
        String[] strs1 = l1.split(",");
        String[] strs2 = l2.split("/");
        String[] strs3 = l3.split(",");

        root = new int[strs1.length + 1];
        path = new int[strs2.length];
        child = new int[strs3.length + 1];
        for (int i = 1; i <= strs1.length; i++) {
            root[i] = Integer.parseInt(strs1[i - 1]);
        }
        for (int i = 1; i < strs2.length; i++) {
            path[i] = Integer.parseInt(strs2[i]);
        }
        for (int i = 1; i <= strs3.length; i++) {
            child[i] = Integer.parseInt(strs3[i - 1]);
        }

        int start = dfsGetChildRoot(1, 1);
        dfsUpdate(start, 1);

        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int v : root) {
            if (v != 0) {
                res.append(v).append(",");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        System.out.println(res);
    }

    private static void dfsUpdate(int p, int q) {
        if (q >= child.length) {
            return;
        }
        if (child[q] != 0) {
            root[p] = child[q];
        }
        dfsUpdate(p << 1, q << 1);
        dfsUpdate((p << 1) + 1, (q << 1) + 1);
    }

    private static int dfsGetChildRoot(int x, int step) {
        if (root[x] == 0) {
            return -1;
        }
        if (path[step] != root[x]) {
            return -1;
        }
        if (step == path.length - 1) {
            return x;
        }

        int l = dfsGetChildRoot(x << 1, step + 1);
        int r = dfsGetChildRoot((x << 1) + 1, step + 1);
        if (l != -1) {
            return l;
        }
        return r;
    }
}
