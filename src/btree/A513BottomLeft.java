package btree;

public class A513BottomLeft {
  int resultVal;
  int resultDep = -1;

  public int findBottomLeftValue(TreeNode root) {
    search(root, 0);
    return resultVal;
  }

  private void search(TreeNode node, int depth) {
    if (node == null)
      return;
    if (isLeaf(node) && depth > resultDep) {
      resultVal = node.val;
      resultDep = depth;
    }
    search(node.left, depth + 1);
    search(node.right, depth + 1);
  }

  private boolean isLeaf(TreeNode left) {
    return left != null && left.left == null && left.right == null;
  }
}
