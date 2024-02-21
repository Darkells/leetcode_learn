package New2024.Daily;

public class Daily0220 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        return finder(preorder, 0, preLen - 1, inorder, 0, inLen -1);
    }

    private TreeNode finder(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        int rootVal = preorder[preL];
        int l = inL;
        while (l <= inR && inorder[l] != rootVal) {
            l++;
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = finder(preorder, preL + 1, preL + l - inL, inorder, inL, l - 1);
        root.right = finder(preorder, preL + l - inL + 1, preR, inorder, l + 1, inR);
        return root;
    }

    //better answer

    int pre = 0, in = 0; // 前序和中序的索引
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre == preorder.length) return null;
        if (inorder[in] == stop) {
            //到达数组限定点
            in++;
            return null;
        }
        //创建树节点，然后向后移动pre
        TreeNode root = new TreeNode(preorder[pre++]);
        //创建左右子树
        root.left = build(preorder,inorder,root.val);//到达根节点，中序遍历根在中间
        root.right = build(preorder,inorder,stop);
        return root;
    }
}
