package btree;

public class A404SumOfLLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    if(isLeave(root.left)) {
      return root.left.val + sumOfLeftLeaves(root.right);
    }else {
      return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
  }

  private boolean isLeave(TreeNode left) {
    return left != null && left.left == null && left.right == null;
  }
}
