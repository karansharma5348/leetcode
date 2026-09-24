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

    TreeNode prev = null;

    TreeNode g1first = null;
    TreeNode g1sec = null;

    TreeNode g2first = null;
    TreeNode g2sec = null;

    int galat = 0;

    public void fun(TreeNode root) {

        if (root == null)
            return;

        // Left
        fun(root.left);

        // Root
        if (prev != null && root.val < prev.val) {

            if (galat == 0) {
                g1first = prev;
                g1sec = root;
                galat++;
            } 
            else {
                g2first = prev;
                g2sec = root;
                galat++;
            }
        }

        prev = root;

        // Right
        fun(root.right);
    }

    public void recoverTree(TreeNode root) {

        fun(root);

        if (galat == 1) {
            int temp = g1first.val;
            g1first.val = g1sec.val;
            g1sec.val = temp;
        }
        else {
            int temp = g1first.val;
            g1first.val = g2sec.val;
            g2sec.val = temp;
        }
    }
}