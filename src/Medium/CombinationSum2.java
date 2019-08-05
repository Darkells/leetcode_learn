package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/8/1 15:00
 */

public class CombinationSum2{
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            if (res.contains(tmp_list))
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (start > i && candidates[start] == candidates[start - 1]) {
                continue;
            }
            if (target < candidates[start]) break;
            tmp_list.add(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start + 1, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }


    //Leetcode解题
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0 , len, target, new Stack<>(), res);
        return res;
    }

    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.add(candidates[i]);
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }
}