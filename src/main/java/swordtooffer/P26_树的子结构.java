package swordtooffer;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值
public class P26_树的子结构 {

    //先序遍历树 A 中的每个节点 nA （对应函数 isSubStructure(A, B)）
    //时间复杂度 O(MN)
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //当 树 A 为空 或 树 B 为空 时，直接返回 false
        if (A == null || B == null) {
            return false;
        }
        //        返回值： 若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
//        以 节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
//        树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
//        树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //判断树 A 中 以 nA 为根节点的子树 是否包含树 B
    public boolean recur(TreeNode A, TreeNode B) {
        //当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true
        if (B == null) return true;
        //当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false；
        if (A == null || A.val != B.val) return false;
        //判断 A 和 B 的左子节点是否相等,判断 A 和 B 的右子节点是否相等
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
