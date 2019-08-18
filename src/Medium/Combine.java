package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/8/12 14:56
 */
public class Combine {
    private void backtrack(int n, int k, int start, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            temp.add(i);
            backtrack(n,k-1,i + 1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (k > n) {
            return res;
        }
        backtrack(n,k,1,temp,res);
        return res;
    }
}
