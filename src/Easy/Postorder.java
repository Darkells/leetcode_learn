package Easy;

/**
 * @author Dark
 * @date 2019/5/6 9:39
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Postorder {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return result;
        }
        result.add(result.size(),root.val);
        for(int i = root.children.size() - 1; i >= 0; i--){
            result.addAll(0,postorder(root.children.get(i)));
        }

        return result;

    }
}
