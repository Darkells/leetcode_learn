package Easy;

/**
 * @author Dark
 * @date 2019/3/25 22:40
 */

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class LevelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if (root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            //temp初始化要放在此处，每次循环之后要置空
            List<Integer> temp = new ArrayList<>();
            int level = queue.size();
            for (int i = 0;i < level;i++){
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                temp.add(queue.poll().val);
            }
            stack.push(temp);
            temp.clear();
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
