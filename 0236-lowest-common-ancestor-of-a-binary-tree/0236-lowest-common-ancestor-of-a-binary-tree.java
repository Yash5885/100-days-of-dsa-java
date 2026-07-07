class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if we reach the end of a branch, or find p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are not null, current node is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, pass up the non-null child
        return left != null ? left : right;
    }
}