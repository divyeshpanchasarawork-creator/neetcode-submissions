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
class BSTIterator {
    private final List<Integer> list;
    private int i;
    public BSTIterator(TreeNode root) {
        i = 0;
        List<Integer> temp = new ArrayList<>();
        inOrder(root, temp);
        list = temp;
    }
    
    public int next() {
        return list.get(i++);
    }
    
    public boolean hasNext() {
        return i < list.size();
    }

    private void inOrder(TreeNode root, List<Integer> temp) {
        if (root == null) return;
        inOrder(root.left, temp);
        temp.add(root.val);
        inOrder(root.right, temp);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */