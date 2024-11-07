import type { TreeNode } from "./TreeNode.ts";

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
  return search(root);

  // return p (or q) if only p (or q) is in the subtree with root `node`
  // return the LCA of p and q if both p and q are in the subtree
	function search(node: TreeNode | null): TreeNode | null {
    if(node === p || node === q || node === null) {
      return node;
    }
    const left = search(node.left);
    const right = search(node.right);
    // left subtree has p or q
    // and right subtree also has p or q
    // then node is the LCA
    if(left !== null && right !== null) return node; 
    // invalid search
    if(left == null && right == null) return null; 
    
    return left !== null ? left: right; 
  }
};