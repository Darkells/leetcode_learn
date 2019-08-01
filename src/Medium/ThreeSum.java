package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dark
 * @2019/7/26 15:31
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //定义双指针，动态初始化，一个在选定数字前面，一个在数组末尾
        int i = 0,j = 0;
        int sum = 0;
        for (int k = 0; k < nums.length; k++) {
            //当nums[k] 大于0时，就不存在三元组和为0
            if (nums[k] > 0) {
                break;
            }
            //相邻相同的数字，以及处理保存过
            if (k > 0 && nums[k] == nums[k + 1]) {
                continue;
            }
            i = k + 1;
            j = nums.length - 1;
            while (i < j) {
                sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
