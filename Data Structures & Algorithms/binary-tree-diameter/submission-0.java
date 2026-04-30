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
        if(root == null){return 0;}
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 0;
        }

        
        TreeNode head = root;
        int diameter = Math.max(diameterOfBinaryTree(head.left), diameterOfBinaryTree(head.right));
        int diameter_head =  maxDepth(head.left) + maxDepth(head.right);
        
        return Math.max(diameter, diameter_head);
    }
}
