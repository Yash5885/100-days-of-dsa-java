import java.util.*;

class Solution {
    int postIndex;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = postorder[postIndex];
        postIndex--;

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.right = build(postorder, rootIndex + 1, right);
        root.left = build(postorder, left, rootIndex - 1);

        return root;
    }
}