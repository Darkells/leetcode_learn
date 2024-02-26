package New2024.Daily;
/*
Range Sum of BST
 */

public class Daily0226 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (null == root) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
