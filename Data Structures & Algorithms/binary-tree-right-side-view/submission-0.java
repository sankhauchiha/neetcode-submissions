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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        rightSideView(root,list,0);
        return list;
    }

    public void rightSideView(TreeNode root, List<Integer> li ,int l){
        if(root==null){ return; }
        if(li.size()<=l){
           li.add(root.val);
        }

         rightSideView(root.right, li, l+1);
         rightSideView(root.left, li, l+1);
    }
}
