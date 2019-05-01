package Easy;

import java.util.ArrayList;

/**
 *
 */
public class GetMinimumDifference {
    ArrayList<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int temp = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            temp = list.get(i) - list.get(i - 1);
            if (temp < min)
                min = temp;
        }
        return min;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }
}
