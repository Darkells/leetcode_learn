package Medium;

import Easy.TreeNode;

public class DistributeCoins {
    private int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        ans += Math.abs(L) + Math.abs(R);
        return root.val + L + R - 1;
    }
}
