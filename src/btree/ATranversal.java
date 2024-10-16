package btree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Leetcode 94, 102, 144, 146, 102
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

  public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();

    Queue<TreeNode> q = new ArrayDeque<>();
    List<List<Integer>> sink = new ArrayList<>();
    q.offer(root);
    levelTraverse(q, sink);
    
    return sink;
  }

  public void levelTraverse (Queue<TreeNode> q, List<List<Integer>> sink) {
    if(q.size() == 0) return;
    var size = q.size();
    List<Integer> layer = new ArrayList<>(size);

    for (int i = 0; i < size; i++) {
      var elem = q.poll();
      layer.add(elem.val);

      if(elem.left != null) q.add(elem.left);
      if(elem.right != null) q.add(elem.right);
    }

    sink.add(layer);
    levelTraverse(q, sink);
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
