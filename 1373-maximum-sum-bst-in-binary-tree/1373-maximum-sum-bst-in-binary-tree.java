class Solution {
    int maxSum = 0;

    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = dfs(root.left);
        Info right = dfs(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int currSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currSum);

            int currMin = Math.min(root.val, left.min);
            int currMax = Math.max(root.val, right.max);

            return new Info(true, currMin, currMax, currSum);
        }

        return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}