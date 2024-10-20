package btree;

public class A98ValidateBST {
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isValidBST(TreeNode root, long lb, long ub) {
    if (root == null)
      return true;

    boolean isInBound = lb < root.val && root.val < ub;
    boolean leftIsValid = root.left == null
        || (root.val > root.left.val && isValidBST(root.left, lb, Math.min(root.val, ub)));
    boolean rightIsValid = root.right == null
        || (root.val < root.right.val && isValidBST(root.right, Math.max(lb, root.val), ub));

    return isInBound & leftIsValid && rightIsValid;
  }

  public static void main(String[] args) {
    new A98ValidateBST().isValidBST(
      new TreeNode(2, new TreeNode(1), new TreeNode(3))
    );
  }
}
