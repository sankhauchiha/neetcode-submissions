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
    public boolean compare(TreeNode root, TreeNode subRoot) {
        if(root.left == null && subRoot.left != null) return false;
        if(root.right == null && subRoot.right != null) return false;
        if(root.left != null && subRoot.left == null) return false;
        if(root.right != null && subRoot.right == null) return false;
        if( (root.left == null && subRoot.left == null) && (root.right == null && subRoot.right == null) ) return true;

        if(root.left == null){
            if(root.right.val != subRoot.right.val) return false;
            return compare(root.right, subRoot.right);}

        if(root.right == null){
            if(root.left.val != subRoot.left.val) return false;
            return compare(root.left, subRoot.left);}
        
        if(root.right.val != subRoot.right.val || root.left.val != subRoot.left.val) return false;
        
        return (compare(root.left, subRoot.left) && compare(root.right, subRoot.right)); 
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        TreeNode head = root;
        if(head.val == subRoot.val){
           if(compare(head, subRoot)) return true;
        } 
        
        return (isSubtree(head.left, subRoot) || isSubtree(head.right, subRoot));
        }
    }
