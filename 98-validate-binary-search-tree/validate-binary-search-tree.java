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
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return ans;
    }

    TreeNode prev = null;
    boolean ans = true;

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        //left jyo
        inOrder(root.left);
        

        // root pr kaam kro
        if(prev == null){
            prev = root;

        }else{
            if(root.val <= prev.val){
                ans = false;
            }
            prev = root;

        }
        inOrder(root.right);


    }
}