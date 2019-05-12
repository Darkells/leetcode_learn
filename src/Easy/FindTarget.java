package Easy;

/**
 * @author Dark
 * @date 2019/5/11 10:17
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 */
public class FindTarget {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root,int k){
        if (root == null){
            return false;
        }
        inroder(root);
        int start = 0;
        int end = list.size() - 1;
        while (start < end){
            if (k - list.get(start) > list.get(end)){
                start++;
            }else if (k - list.get(start) < list.get(end)){
                end--;
            }else {
                return true;
            }
        }

        return false;
    }

    private void inroder(TreeNode root){
        if (root == null){
            return;
        }
        inroder(root.left);
        list.add(root.val);
        inroder(root.right);
    }
}
