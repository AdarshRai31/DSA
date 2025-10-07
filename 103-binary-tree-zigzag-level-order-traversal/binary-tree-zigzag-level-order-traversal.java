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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> d = new LinkedList<>();
        d.addLast(root);

        boolean reverse = false;

        while (!d.isEmpty()) {
            int size = d.size();
            List<Integer> currentlevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!reverse) {
                    TreeNode temp = d.removeFirst();
                    currentlevel.add(temp.val);

                    if (temp.left != null) {
                        d.addLast(temp.left);
                    }

                    if (temp.right != null) {
                        d.addLast(temp.right);
                    }
                }
                else {
                    TreeNode temp = d.removeLast();
                    currentlevel.add(temp.val);

                    if (temp.right != null) {
                        d.addFirst(temp.right);
                    }
                    
                    if (temp.left != null) {
                        d.addFirst(temp.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentlevel);
        }
        return result;
    }
}