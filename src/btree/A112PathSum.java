package btree;

public class A112PathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null)
      return false;
    if (isLeaf(root))
      return targetSum == root.val;

    return hasPathSum(root.left, targetSum - root.val) ||
        hasPathSum(root.right, targetSum - root.val);
  }

  private boolean isLeaf(TreeNode left) {
    return left != null && left.left == null && left.right == null;
  }
}
