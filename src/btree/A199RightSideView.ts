import { TreeNode } from "./TreeNode.ts";

function rightSideView(root: TreeNode | null): number[] {
  if (root === null) return [];
  const hasViewed: boolean[] = [];
  const ans: number[] = [];
  visit(root, 0);
  return ans;

  function visit(root: TreeNode | null, level: number) {
    if (root === null) return;
    if(!hasViewed[level]) {
      hasViewed[level] = true;
      ans.push(root.val)
    }
    visit(root.right, level + 1)
    visit(root.left, level + 1)
  }
};