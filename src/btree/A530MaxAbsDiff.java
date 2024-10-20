package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * A530MaxAbsDiff
 */
public class A530MaxAbsDiff {
  List<Integer> sortedValue;

  public int getMinimumDifference(TreeNode root) {
    sortedValue = new ArrayList<>();
    traverse(root);
    return minDiff(sortedValue, 0, Integer.MAX_VALUE);
  }

  private int minDiff(List<Integer> sortedInts, int pos, int acc) {
    if (pos >= sortedInts.size() - 1) {
      return acc;
    }

    return minDiff(sortedInts, pos + 1, Math.min(Math.abs(sortedInts.get(pos) - sortedInts.get(pos + 1)), acc));
  }

  private void traverse(TreeNode rootNode) {
    if (rootNode == null)
      return;
    traverse(rootNode.left);
    sortedValue.addLast(rootNode.val);
    traverse(rootNode.right);
  }

}

// Failed Attempt.
// Only return the max between direct kingship.
class A530MaxAbsDiffAttempt0 {
  public int getMinimumDifference(TreeNode root) {
    return Math.min(
        getMinimumDifference(root.left, root.val),
        getMinimumDifference(root.right, root.val));
  }

  public int getMinimumDifference(TreeNode node, int parentValue) {
    if (node == null)
      return Integer.MAX_VALUE;

    return min3(
        Math.abs(node.val - parentValue),
        getMinimumDifference(node.left, node.val),
        getMinimumDifference(node.right, node.val));
  }

  private static int min3(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }
}