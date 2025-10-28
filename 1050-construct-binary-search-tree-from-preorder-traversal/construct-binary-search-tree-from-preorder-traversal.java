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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return helper(preorder, Integer.MAX_VALUE);
    }
    TreeNode helper(int[] preorder, int bound) {
        if (index >= preorder.length || preorder[index] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, bound);
        
        return root;
    }
}