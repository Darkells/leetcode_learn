package New2024.Daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Kth Largest Sum in a Binary Tree

 */
public class Daily0223 {
    List<Long> res = new ArrayList<>();
    public long kthLargestLevelSum(TreeNode root, int k) {
        dfs(root, 0);
        res.sort(Collections.reverseOrder());
        return res.get(k - 1);
    }

    private void dfs(TreeNode root, int depth) {
        if (null == root) {
            return;
        }

        if (res.size() <= depth) {
            res.add(0L);
        }
        res.set(depth, res.get(depth) + root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
