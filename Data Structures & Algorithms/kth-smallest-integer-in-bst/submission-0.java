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
    public int kthSmallest(TreeNode root, int k) {
        int[] kth = {k};

        return helper(root, kth);
    }

    private int helper(TreeNode root, int[] kth) {
        if (root == null) return -1;
        int left = helper(root.left, kth);
        kth[0]--;
        if (kth[0] == 0) return root.val;
        int right = helper(root.right, kth);
        return left != -1 ? left : right;
    }
}
