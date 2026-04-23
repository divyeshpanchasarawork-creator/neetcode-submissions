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
    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrder(root);
    }

    private List<Integer> postOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> left = postOrder(root.left);
        List<Integer> right = postOrder(root.right);

        left.addAll(right);
        left.add(root.val);

        return left;
    }
}