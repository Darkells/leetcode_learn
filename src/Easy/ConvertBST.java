package Easy;

public class ConvertBST {
    private int num = 0;
    public TreeNode convertBST(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.right != null){
            root.right = convertBST(root.right);
        }
        num += root.val;
        root.val = num;
        if (root.left != null){
            root.left = convertBST(root.left);
        }
        return root;
    }
}
