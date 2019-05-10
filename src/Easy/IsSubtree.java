package Easy;

/**
 * @author Dark
 * @date 2019/5/5 10:32
 */

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (myIsSubTree(s, t)) {
            return true;
        }
        return s != null && (isSubtree(s.left, t)) || isSubtree(s.right, t);
    }

    public boolean myIsSubTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }
        if (s.val != t.val) {
            return false;
        }

        return myIsSubTree(s.left, t.left) && myIsSubTree(s.right, t.right);
    }
}
