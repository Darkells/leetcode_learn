package Medium;

import Easy.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inlen = inorder.length;
        int poslen = postorder.length;
        return helper(postorder, 0 , poslen - 1, inorder, 0 , inlen);
    }

    /**
     *
     * @param postorder  后序遍历
     * @param posL      后序遍历的首元素
     * @param posR      后序遍历的末元素
     * @param inorder   中序遍历
     * @param inL       中序遍历的首元素
     * @param inR       中序遍历的末元素
     * @return
     */
    private TreeNode helper(int[] postorder, int posL, int posR, int[] inorder, int inL, int inR) {
        if (posL > posR || inL > inR) {
            return null;
        }

        //前序遍历首元素为该二叉树的根节点
        int rootval = postorder[posR];
        int l = inL;
        //中序遍历找到根节点，划分左右子树
        while (l <= inR && inorder[l] != rootval) {
            l++;
        }
        TreeNode root = new TreeNode(rootval);
        root.left = helper(postorder, posL, l - 1 - inL + posL, inorder, inL, l - 1);
        root.right = helper(postorder, posR + l - inR, posR - 1, inorder, l + 1, inR);
        return root;
    }
}
