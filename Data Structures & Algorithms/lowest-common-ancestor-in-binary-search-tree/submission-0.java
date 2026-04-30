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
    public TreeNode search(TreeNode head, int max, int min){
        if(head.val > max){
            TreeNode tail = head.left;
            if(tail.val == max || tail.val == min) return tail;
            return search(tail, max, min);
        }

        if(head.val < min){
            TreeNode tail = head.right;
            if(tail.val == max || tail.val == min) return tail;
            return search(tail, max, min);
        }

        return head;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
         
        return search(root, max, min);
    }
}
