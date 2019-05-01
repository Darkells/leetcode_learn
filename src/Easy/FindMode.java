package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindMode {
    Map<Integer, Integer> map = new HashMap();
    int counter = 0;                                //计数器，记录众数出现的次数
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[]{};

        dfs(root);                                  // 中序遍历树

        List<Integer> list = new ArrayList();
        for(int key : map.keySet()){
            if(map.get(key) == counter)
                list.add(key);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;

    }
    public void dfs(TreeNode root){
        if(root.left != null)
            dfs(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        counter = Math.max(counter, map.get(root.val));
        if(root.right != null)
            dfs(root.right);

    }
}
