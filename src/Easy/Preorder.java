package Easy;

/**
 * @author Dark
 * @date 2019/5/6 9:15
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * <p>
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Preorder {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        } else {
            result.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                preorder(root.children.get(i));
            }
            return result;
        }
    }
}
