package greedy;

import btree.TreeNode;

public class A968BnaryTreeCams {
  int numOfCam = 0;

  public int minCameraCover(TreeNode root) {
    numOfCam = 0;
    traverse(root);

    if (stateOfNode(root) == 0) {
      numOfCam++;
    }

    return numOfCam;
  }

  private void traverse(TreeNode root) {
    if (root == null)
      return;
    traverse(root.left);
    traverse(root.right);

    if (stateOfNode(root.left) == 0 || stateOfNode(root.right) == 0) {
      // both children don't have a camera
      // we place a camera on it
      root.val = 2;
      numOfCam++;
    } else if (stateOfNode(root.left) == 2 || stateOfNode(root.right) == 2) {
      // one of the children have a camera
      root.val = 1;
    } else {
      // both children have been covered
      // to get the min num of cam, we let its parent to place a camera
      root.val = 0;
    }
  }

  // 0 - not covered
  // 1 - covered
  // 2 - has a cam
  private int stateOfNode(TreeNode node) {
    if (node == null)
      return 1;
      // this line causes error, but i don't know why
    // if(stateOfNode(node.left) == 2 || stateOfNode(node.right) == 2) 
    //   return 1; 
    return node.val;
  }
}
