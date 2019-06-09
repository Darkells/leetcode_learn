package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的两颗树可能会有 1 到 100 个结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Dark
 * @date 2019/6/9 7:46
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        dfs(root1, r1);
        dfs(root2, r2);
        return r1.equals(r2);
    }

    private void dfs(TreeNode root, List<Integer> r) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                r.add(root.val);
            }
            dfs(root.left, r);
            dfs(root.right, r);
        }
    }
}
