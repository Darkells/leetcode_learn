package Easy;

/**
 * @author Dark
 * @date 2019/5/13 9:59
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   2
 * <p>
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class FindSecondMinimumValue {
    //错的  限制于2^32-1
    Set<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        dfs(root);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            return iterator.next();
        }
        return -1;
    }

    public void dfs(TreeNode root) {
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
