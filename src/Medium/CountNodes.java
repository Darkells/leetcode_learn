package Medium;

import Easy.TreeNode;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/10/3 16:07
 */
public class CountNodes {
    //常规递归做法  题目给予是完全二叉树
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        //如果左右子树高度相等，则左子树为完全二叉树，进一步计算右子树
        if (ld == rd ) return (1 << ld) + countNodes(root.right);
        //不相等，则右子树为完全二叉树，计算左子树
        else return (1 << rd) + countNodes(root.left);
    }

    private int getDepth(TreeNode r) {
        int depth = 0;
        while(r != null) {
            depth++;
            r = r.left;
        }
        return depth;
    }
}
