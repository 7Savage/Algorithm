package 笔试.小米;

import swordtooffer.TreeNode;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class Main2 {
    public Node  Convert(Node pRootOfTree) {
        Node head = converNode(pRootOfTree,null);
        while (head!=null&&head.left!=null){
            head=head.left;
        }
        return head;

    }

    public Node converNode(Node root,Node lastList){
        if (root==null){
            return null;
        }
        if (root.left!=null){
            lastList=converNode(root.left,lastList);
        }
        root.left=lastList;
        if (lastList!=null){
            lastList.right= root;
        }
        lastList= root;
        if (root.right!=null){
            lastList=converNode(root.right,lastList);
        }
        return lastList;
    }
}
