package Easy;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 *      4
 *    /  \
 *   2     7
 *  / \   / \
 * 1  3  6   9
 * 输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);

        return root;
    }
}
