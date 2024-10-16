package btree;

public class A101SymBTree {
  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if(left == null && right == null) return true;
    if(left == null || right == null) return false;

    return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
  }
}
