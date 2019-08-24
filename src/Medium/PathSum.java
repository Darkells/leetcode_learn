package Medium;

import Easy.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        //判断叶子节点
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<>(temp));
        }
        helper(root.left, sum - root.val, res, temp);
        helper(root.right, sum - root.val, res, temp);
        temp.remove(temp.size() - 1);
    }
}
