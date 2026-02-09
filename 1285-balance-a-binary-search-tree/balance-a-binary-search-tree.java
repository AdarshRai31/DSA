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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inorder(root, arr);
        return create(0, arr.size() - 1, arr);
    }
    public void inorder(TreeNode node, List<TreeNode> arr) {
        if (node == null) {
            return;
        }
        inorder(node.left, arr);
        arr.add(node);
        inorder(node.right, arr);
    }
    public TreeNode create(int l, int r, List<TreeNode> arr) {
        if (l > r) return null;

        int mid = l + (r - l) / 2;
        
        TreeNode root = arr.get(mid);
        root.left = create(l, mid-1, arr);
        root.right = create(mid+1, r, arr);
        return root;
    }
}