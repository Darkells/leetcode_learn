package Easy;

/**
 * @author Dark
 * @date 2019/3/24 22:22
 */

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null){
            if(p.val != q.val){
                return false;
            }else{
                return isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);
            }
        }else{
            if(p==null&&q==null){
                return true;
            }else{
                return false;
            }
        }
    }
}
