package Easy;

/**
 * @author Dark
 * @date 2019/3/26 22:21
 */

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            //空树是平衡二叉树
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            //左右子树高度差大于1，不是平衡二叉树
            return false;
        } else {
            //递归判断左右子树是否为平衡二叉树
            return isBalanced(root.right) && isBalanced(root.left);
        }
    }

    //计算二叉树的深度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        //通过左右子树最大值，返回最大值
        return Math.max(left, right) + 1;
    }
}
