package Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int maxLen = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxLen = maxLen > dp[i] ? maxLen : dp[i];
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            if (maxLen == dp[i]) {
                if (res.size() == 0) {
                    res.add(nums[i]);
                    maxLen--;
                } else {
                    if (res.get(res.size() - 1) % nums[i] == 0) {
                        res.add(nums[i]);
                        maxLen--;
                    }
                }
            }
        }

        return res;

    }
}
