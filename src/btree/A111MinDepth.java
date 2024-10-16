package btree;

public class A111MinDepth {
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    if (root.left != null && root.right == null)
      return 1 + minDepth(root.left);
    if (root.right != null && root.left == null)
      return 1 + minDepth(root.right);

    return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
  }
}
