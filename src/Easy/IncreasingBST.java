package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dark
 * @date 2019/6/10 10:21
 */
public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        return  increasingBST(root,null);
    }
    public TreeNode increasingBST(TreeNode root,TreeNode next){
        if(root==null) return null;
        if(root.right==null) root.right = next;
        else root.right = increasingBST(root.right,next);
        if(root.left==null) return root;
        next = root;
        TreeNode ans = increasingBST(root.left,next);
        root.left = null;

        return ans;
    }
}
