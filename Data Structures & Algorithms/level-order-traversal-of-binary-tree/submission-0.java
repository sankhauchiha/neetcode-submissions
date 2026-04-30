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
    public void createlevel(List<List<Integer>> ls, int l, TreeNode root){
        if(root == null) return;
        
        if(l >= ls.size()){
            List<Integer> lt = new ArrayList<>();
            lt.add(root.val);
            ls.add(lt);
        }else{
            ls.get(l).add(root.val);
        }

        createlevel(ls, l+1, root.left);
        createlevel(ls, l+1, root.right);
    }

    public List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> list = new ArrayList<>();
        createlevel(list, 0, root);
        return list;
    }
}
