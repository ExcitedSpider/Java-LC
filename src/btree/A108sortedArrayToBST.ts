import { TreeNode } from "./TreeNode.ts";

function sortedArrayToBST(nums: number[]): TreeNode | null {
  return buildTree(0, nums.length - 1);
  
  function buildTree(left: number, right: number): TreeNode | null {
    if(left > right) {
      return null;
    }if(left == right) {
      return new TreeNode(nums[left])
    }else {
      const mid = left + Math.floor((right - left) / 2);
      return new TreeNode(
        nums[mid],
        buildTree(left, mid - 1),
        buildTree(mid + 1, right),
      )
    }
  }
};