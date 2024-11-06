import type { TreeNode } from "./TreeNode.ts";

function kthSmallest(root: TreeNode | null, k: number): number {
  let counter = 0;
  let ans = 0;
  traverse(root);
  return ans;

  function traverse(node: TreeNode | null) {
    if(!node) return;

    node?.left && traverse(node.left);
    counter++;
    if (counter === k) {
      ans = node?.val;
    } else {
      node?.right && traverse(node.right);
    }
  }
};