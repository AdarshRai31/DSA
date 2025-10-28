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
    public void recoverTree(TreeNode root) {
        helper(root);
        if (last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode last = null;
    TreeNode mid = null;
    void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);

        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
                mid = node;
            }
            else {
                last = node;
            }
        }
        
        prev = node;
        helper(node.right);
    }
    
}