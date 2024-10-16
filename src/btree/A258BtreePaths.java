package btree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A258BtreePaths {
   public List<String> binaryTreePaths(TreeNode node) {
    List<String> result = new ArrayList<>();
    binaryTreePaths(node, new ArrayList<>(), result);
    return result;
  }

  public void binaryTreePaths(TreeNode node, List<Integer> path, List<String> result) {
    if (node == null)
      return;

    path.add(node.val);
    if (node.left == null && node.right == null) {
      result.add(pathToString(path));
    } else {
      binaryTreePaths(node.left, new ArrayList<>(path), result);
      binaryTreePaths(node.right, new ArrayList<>(path), result);
    }
  }

  private String pathToString(List<Integer> path) {
    return path.stream().map(String::valueOf).collect(Collectors.joining("->"));
  }

  // Very declarative and self-proved
  // However, perf is bad
  public List<String> binaryTreePaths0(TreeNode node) {
    if (node == null)
      return List.of();
    if (node.left == null && node.right == null) {
      return List.of(Integer.toString(node.val));
    } else {
      var lpaths = binaryTreePaths0(node.left);
      var rpaths = binaryTreePaths0(node.right);

      return Stream
          .concat(lpaths.stream(), rpaths.stream())
          .map(str -> node.val + "->" + str)
          .toList();
    }
  }

  public static void main(String[] args) {
    var it0 = List.of("1", "2", "3");
    var it1 = List.of("4", "5", "6");
    it0.addAll(it1);
    System.err.println(it0);
  }
}
