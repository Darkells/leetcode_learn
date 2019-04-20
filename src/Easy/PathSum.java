package Easy;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class PathSum {
    public int pathSum(TreeNode root,int sum){
        int res = 0;
        if (root == null){
            return res;
        }
        //递归到任意一个节点
        return dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public int dfs (TreeNode root,int sum){
        //记录路径数量
        int res = 0;
        if (root == null){
            return res;
        }
        if (root.val == sum){
            res++;
        }
        res += dfs(root.left,sum - root.val);
        res += dfs(root.right,sum - root.val);
        return res;
    }
}
