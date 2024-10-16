package btree;

import java.util.LinkedList;
import java.util.List;

// Leetcode 144 - 146
public class ATranversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ls = new LinkedList<>();
    preorderTraversal(root, ls);
    return ls;
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ls = new LinkedList<>();
    postorderTraversal(root, ls);
    return ls;
  }

  private void preorderTraversal(TreeNode root, List<Integer> acc) {
    if (root == null)
      return;
    acc.add(root.val);
    preorderTraversal(root.left, acc);
    preorderTraversal(root.right, acc);
  }

  private void postorderTraversal(TreeNode root, List<Integer> acc) {
    if (root == null)
      return;
    preorderTraversal(root.left, acc);
    preorderTraversal(root.right, acc);
    acc.add(root.val);
  }
}
