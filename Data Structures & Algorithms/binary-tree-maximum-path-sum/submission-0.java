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
     int sum = Integer.MIN_VALUE;
    int findPathSum(TreeNode root){
        if(root == null) return 0;

        int currentVal = root.val;
        int left = Math.max(0, findPathSum(root.left));
        int right = Math.max(0, findPathSum(root.right));

        sum = Math.max(sum, left + right + currentVal);
        
        return Math.max(left, right) + currentVal;
    }

    public int maxPathSum(TreeNode root) {
        findPathSum(root);
        return sum;
    }
}
