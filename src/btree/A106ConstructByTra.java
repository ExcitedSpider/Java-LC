package btree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class A106ConstructByTra {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Function<int[], List<Integer>> box = ints -> Arrays.stream(ints).boxed().toList();

    return buildTree(box.apply(inorder), box.apply(postorder));
  }

  public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
    if (inorder.size() == 0)
      return null;

    var root = new TreeNode(postorder.get(postorder.size() - 1));

    var pos = inorder.indexOf(root.val);

    root.left = buildTree(
        inorder.subList(0, pos),
        postorder.subList(0, pos));
    root.right = buildTree(
        inorder.subList(pos + 1, inorder.size()),
        postorder.subList(pos, postorder.size() - 1));

    return root;
  }
}
