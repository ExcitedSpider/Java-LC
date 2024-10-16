package btree;

public class A222CountComplete {
  public int countNodes(TreeNode root) {
    if(root == null) return 0;
    if(root.left == null) return 1;

    return 1 + countNodes(root.left) + countNodes(root.right);
  }

}
