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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        fun(root,res);
        return res;
    }

    public void fun(TreeNode root, List<Integer>res){
        if(root == null){
            return;
        }
        //root
        res.add(root.val);
        //left
        fun(root.left,res);
        
        //right
        fun(root.right,res);
    }
}