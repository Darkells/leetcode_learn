package Medium;

import Easy.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int prelen = preorder.length;
        int inlen = inorder.length;
        return helper(preorder,0,prelen - 1,inorder,0,inlen - 1);
    }

    /**
     *
     * @param preorder  前序遍历
     * @param preL      前序遍历的首元素
     * @param preR      前序遍历的末元素
     * @param inorder   中序遍历
     * @param inL       中序遍历的首元素
     * @param inR       中序遍历的末元素
     * @return
     */
    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        //前序遍历首元素为该二叉树的根节点
        int rootval = preorder[preL];
        int l = inL;
        //中序遍历找到根节点，划分左右子树
        while (l <= inR && inorder[l] != rootval) {
            l++;
        }
        TreeNode root = new TreeNode(rootval);
        root.left = helper(preorder, preL + 1, preL + l - inL, inorder, inL, l - 1);
        root.right = helper(preorder, preL + l - inL + 1, preR, inorder, l + 1, inR);
        return root;
    }
}
