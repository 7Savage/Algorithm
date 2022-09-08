package 笔试.腾讯音乐;


import swordtooffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    static ArrayList<TreeNode> res = new ArrayList<>();

    public static ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        int[] preorder = new int[preOrder.size()];
        for (int i = 0; i < preorder.length; i++) {
            preorder[i] = preOrder.get(i);
        }
        int[] inorder = new int[inOrder.size()];
        for (int i = 0; i < inorder.length; i++) {
            inorder[i] = inOrder.get(i);
        }
        build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return res;
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        List<Integer> indexList = new ArrayList<>();
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                indexList.add(i);
            }
        }

        TreeNode root = null;
        for (int index : indexList) {
            root = new TreeNode(rootVal);
            if (preStart == 0) {
                res.add(root);
            }
            root.left = build(preorder, preStart + 1, preStart + (index - inStart), inorder, inStart, index - 1);
            root.right = build(preorder, preStart + (index - inStart + 1), preEnd, inorder, index + 1, inEnd);
        }
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        pre.add(1);
        pre.add(1);
        pre.add(2);
        ArrayList<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(1);
        in.add(2);
        in.add(1);
        getBinaryTrees(pre, in);
    }
}
