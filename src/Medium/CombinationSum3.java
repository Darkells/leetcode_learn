package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Dark
 * @2019/10/1 14:34
 */
public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>();
        helper(k, 1, n, temp);
        return res;
    }

    public void helper(int k, int start, int n, List<Integer> temp) {
        if (k == 0 || n == 0) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = start; i < 10; i++) {
            if (n - i < 0) {
                break;
            }
            temp.add(i);
            helper(k - 1, i + 1, n - i, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
