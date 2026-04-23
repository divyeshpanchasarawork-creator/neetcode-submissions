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
    public int sumNumbers(TreeNode root) {
        int[] total = {0};
        helper(root, 0, total);
        return total[0];
    }

    private void helper(TreeNode root, int curr, int[] t) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            curr *= 10;
            curr += root.val;
            t[0] += curr;
            return;
        }
        curr *= 10;
        curr += root.val;
        helper(root.left, curr, t);
        helper(root.right, curr, t);
    }
}