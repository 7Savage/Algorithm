package tree;

import tree.TreeNode;

public class BST {
    public final TreeNode rootNode;

    public BST(int value) {
        rootNode = new TreeNode(value);
    }

    public TreeNode insert(int value) {
        TreeNode newNode = new TreeNode(value);
        TreeNode currentRoot = rootNode;
        while (true) {
            if (value == currentRoot.val) {
                return null;
            } else if (value < currentRoot.val) {
                if (currentRoot.left != null) {
                    currentRoot = currentRoot.left;
                } else {
                    return currentRoot.left = newNode;
                }
            } else {
                if (currentRoot.right != null) {
                    currentRoot = currentRoot.right;
                } else {
                    return currentRoot.right = newNode;
                }
            }
        }
    }

    public TreeNode search(int value) {
        TreeNode currentRoot = rootNode;
        while (true) {
            if (currentRoot == null) {
                return null;
            }
            if (value == currentRoot.val) {
                return currentRoot;
            } else if (value < currentRoot.val) {
                currentRoot = currentRoot.left;
            } else {
                currentRoot = currentRoot.right;
            }
        }
    }


}
