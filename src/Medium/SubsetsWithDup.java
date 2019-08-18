package Medium;

import java.util.*;

/**
 * @author Dark
 * @2019/8/15 14:29
 */
public class SubsetsWithDup {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        backtrack(nums,0,new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
