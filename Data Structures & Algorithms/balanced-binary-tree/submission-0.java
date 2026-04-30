/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;


        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);

        if( Math.abs(ldepth - rdepth) > 1){
            return false;
        }

        boolean res1 = isBalanced(root.left);
        boolean res2 = isBalanced(root.right);

        return (res1 && res2);
    }
}
