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
    int ans = 0;
    public void path(TreeNode root, int cmp){
        if(root == null) return;
        if(cmp<=root.val){
            ans++;
            cmp = root.val;
        }
        path(root.left, cmp);
        path(root.right, cmp);
    }

    public int goodNodes(TreeNode root) {
        path(root, root.val);
        return ans;
    }
}
