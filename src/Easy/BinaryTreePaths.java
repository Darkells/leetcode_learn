package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        List<String> templeft = binaryTreePaths(root.left);
        for (String s : templeft) {
            list.add(root.val + "->" + s);
        }
        List<String> tempright = binaryTreePaths(root.right);
        for (String s : tempright) {
            list.add(root.val + "->" + s);
        }

        return list;
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<String>();
        path(root, list, new String());
        return list;
    }

    public void path(TreeNode root, List<String> list, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(s + root.val);
            return;
        }
        if (root.left != null) {
            path(root.left, list, s + root.val + "->");
        }
        if (root.right != null) {
            path(root.right, list, s + root.val + "->");
        }
    }
}

