package 笔试题.华为.第三题;

import java.util.*;

public class Main {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<String, Integer> map = new HashMap<>();
    static List<TreeNode> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] values = s.substring(1, s.length() - 1).split(",");
        Main main = new Main();
        TreeNode root = main.buildTree(0, values);
        main.dfs(root);
        int index = 0;
        int maxDepth = 0;
        for (int i = 0; i < res.size(); i++) {
            int depth = main.maxDepth(res.get(i));//子树最大深度
            if (depth > maxDepth) {
                index = i;
                maxDepth = depth;
            }
        }
        //不包含只有一个节点的子树
        if (maxDepth == 1) {
            System.out.println("-1");
            return;
        }
        //获取深度最长的子树
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        TreeNode node = res.get(index);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    sb.append("null").append(",");
                } else {
                    sb.append(poll.val).append(",");
                    if (depth < maxDepth) {
                        queue.add(poll.left);
                        queue.add(poll.right);
                    }
                }
            }
            depth++;
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }

    public TreeNode buildTree(int index, String[] values) {
        if (index >= values.length) {
            return null;
        }
        String value = values[index];
        if (value.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = buildTree(2 * index + 1, values);
        root.right = buildTree(2 * index + 2, values);
        return root;
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);
        String tree = root.val + "," + left + "," + right;
        int count = map.getOrDefault(tree, 1);
        if (count == 2) {
            res.add(root);
        }
        map.put(tree, count + 1);
        return tree;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
