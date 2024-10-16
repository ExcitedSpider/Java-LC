package btree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

// Efficient construction by traverse output 
public class A106ConstructByTraE {
  // pi[i] := the index of value i in list 
  Map<Integer, Integer> inorderPi;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    inorderPi = new HashMap<>();
    for (int i = 0; i < postorder.length; i++) {
      inorderPi.put(inorder[i], i);
    }

    return buildTree(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
  }

  public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart, int posEnd) {
    if (inStart > inEnd)
      return null;

    int rootVal = postorder[posEnd];
    var root = new TreeNode(rootVal);

    int rootIndex = find(inorder, rootVal);
    int leftTreeSize = rootIndex - inStart;

    root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, posStart, posStart + leftTreeSize - 1);
    root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, posStart + leftTreeSize, posEnd - 1);

    return root;
  }

  private int find(int[] inorder, int val) {
    return inorderPi.get(val);
  }

  public static void main(String[] args) {
    int[] inorder = { 9, 3, 15, 20, 7 };
    int[] postorder = { 9, 15, 7, 20, 3 };

    new A106ConstructByTraE().buildTree(inorder, postorder);
  }
}
