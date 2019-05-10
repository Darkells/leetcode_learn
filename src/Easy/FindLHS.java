package Easy;

/**
 * @author Dark
 * @date 2019/5/6 8:52
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 */
public class FindLHS {
    public int findLHS(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        int max = 0;
//        for (int num : map.keySet()) {
//            //处理相差1的键
//            if (map.containsKey(num + 1)){
//                int temp = map.get(num) + map.get(num + 1);
//                max = Math.max(max,temp);
//            }
//        }
//
//        return max;
        Arrays.sort(nums);
        int i = 0,j = 0;
        int max = Integer.MIN_VALUE;
        if (nums.length == 0){
            return 0;
        }
        while (j < nums.length){
            while (nums[j] - nums[i] <= 1){
                j++;
            }
            if (nums[j - 1] - nums[i] == 1){
                max = Math.max(max,j - i);
                i++;
            }
            while (i < nums.length && nums[i] == nums[i - 1]){
                i++;
            }
        }
        return max;
    }
}
