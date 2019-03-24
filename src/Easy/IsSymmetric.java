package Easy;

/**
 * @author Dark
 * @date 2019/3/24 22:24
 */

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return isSameTree(root.left,root.right);
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p != null && q != null && p.val == q.val){
            return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
        }else{
            return false;
        }
    }
}
