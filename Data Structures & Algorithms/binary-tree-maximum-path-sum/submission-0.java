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
    public int maxPathSum(TreeNode root) {
        int[] val = {Integer.MIN_VALUE};
        helper(root, val);
        return val[0];
    }

    private int helper(TreeNode root, int[] val) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left, val));
        int right = Math.max(0, helper(root.right, val));

        val[0] = Math.max(val[0], left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
