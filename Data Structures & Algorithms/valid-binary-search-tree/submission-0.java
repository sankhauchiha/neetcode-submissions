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
      public void inorder(TreeNode root, ArrayList<Integer> arr){
       if(root == null) return;

       inorder(root.left, arr);
       arr.add(root.val);
       inorder(root.right, arr);
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        for(int i = 0, n = arr.size() ; i < n-1 ; i++){
            if(arr.get(i)>=arr.get(i+1)) return false;
        }
        
        return true;
    }
}
