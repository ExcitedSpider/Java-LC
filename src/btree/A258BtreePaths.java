package btree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class A258BtreePaths {

  public List<String> binaryTreePaths(TreeNode node) {
    List<String> result = new ArrayList<>();
    if (node == null)
      return result;
    if (node.left == null && node.right == null) {
      result.add(Integer.toString(node.val));
      return result;
    } else {
      var lpaths = binaryTreePaths(node.left);
      var rpaths = binaryTreePaths(node.right);

      for (String path : lpaths) {
        result.add(node.val + "->" + path);
      }
      for (String path : rpaths) {
        result.add(node.val + "->" + path);
      }
      return result;
    }
  }

  public static void main(String[] args) {
    var it0 = List.of("1", "2", "3");
    var it1 = List.of("4", "5", "6");
    it0.addAll(it1);
    System.err.println(it0);
  }
}
