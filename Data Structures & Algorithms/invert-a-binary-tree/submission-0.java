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
    public void swap(TreeNode root){
        if(root.left == null && root.right == null){
            return ;
        }

        TreeNode head = root;
        TreeNode lhead = head.left;
        TreeNode rhead = head.right;

        head.left = rhead;
        head.right = lhead;

        if(head.right != null){
            swap(head.right);
        }
        if(head.left != null ){
            swap(head.left);
        }

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        swap(root);
        return root;
        
    }
}
