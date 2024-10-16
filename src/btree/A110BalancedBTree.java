package btree;

public class A110BalancedBTree {
  public boolean isBalanced(TreeNode root) {
      if(root == null) return true;
      if(root.left == null && root.right == null) return true;

      return isBalanced(root.left) && 
             isBalanced(root.right) && 
             Math.abs(height(root.left) - height(root.right)) <= 1;
  }

  public int height(TreeNode root) {
    if(root == null) return 0;

    return Math.max(1 + height(root.left), 1 + height(root.right));
  }
}
