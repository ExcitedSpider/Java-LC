package btree;

public class A226InvertBTree {
  public TreeNode invertTree(TreeNode root) {
    return invertTree0(root);
  }

  private TreeNode invertTree0(TreeNode root) {
    if(root == null) return null;

    var it = root.left;
    root.left = root.right;
    root.right = it;

    invertTree0(root.left);
    invertTree0(root.right);

    return root;
  }
}
