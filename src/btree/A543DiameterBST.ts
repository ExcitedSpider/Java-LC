import { TreeNode } from "./TreeNode.ts";

function diameterOfBinaryTree(root: TreeNode | null): number {
  return getMaxLength(root).maxDiameter;

  function getMaxLength(node: TreeNode | null): { length: number, maxDiameter: number } {
      if (!node) return { length: 0, maxDiameter: 0 };

      const left = getMaxLength(node.left);
      const right = getMaxLength(node.right);

      const diameter = left.length + right.length;
      const maxDiameter = Math.max(diameter, left.maxDiameter, right.maxDiameter);

      return { length: Math.max(left.length, right.length) + 1, maxDiameter };
  }
}
