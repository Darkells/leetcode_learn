package Easy;

/**
 * @author Dark
 * @2019/7/12 15:51
 */
public class SumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode root, int s) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) {
            System.out.println((s << 1) + root.val);
            return (s << 1) + root.val;
        }
        return sum(root.left,(s<<1) + root.val) + sum(root.right,(s<<1) + root.val);
    }

}
