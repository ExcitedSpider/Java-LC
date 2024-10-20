package btree;

import java.util.Optional;

public class A617MergeBTree {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if(root1 == null && root2 == null) return null;

      var op1 = Optional.ofNullable(root1).orElse(new TreeNode(0));
      var op2 = Optional.ofNullable(root2).orElse(new TreeNode(0));

      var nRoot = new TreeNode(op1.val + op2.val);
      nRoot.left = mergeTrees(op1.left, op2.left);
      nRoot.right = mergeTrees(op1.right, op2.right);
      return nRoot;
  }
}
