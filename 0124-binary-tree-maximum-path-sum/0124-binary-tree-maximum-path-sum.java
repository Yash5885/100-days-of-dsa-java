class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }

    private int findMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, findMaxPath(root.left));
        int rightSum = Math.max(0, findMaxPath(root.right));

        int currentPathSum = root.val + leftSum + rightSum;

        maxSum = Math.max(maxSum, currentPathSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}