package btree;

public class A700SearchBST {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null)
      return null;
    if (val == root.val)
      return root;
    if (val < root.val)
      return searchBST(root.left, val);
    else
      return searchBST(root.right, val);
  }
}
