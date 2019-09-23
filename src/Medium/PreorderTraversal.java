package Medium;

import Easy.TreeNode;

import java.util.*;

/**
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/9/21 14:54
 */
public class PreorderTraversal {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        DFS(root);
        return res;
    }

    public void DFS(TreeNode root) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        DFS(root.left);
        DFS(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if (root == null) {
            return res;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }
}
