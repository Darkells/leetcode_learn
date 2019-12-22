package Medium;

import java.util.Arrays;

/**
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Makesquare {
    private boolean res = false;
    public boolean makesquare(int[] nums) {
        int C = 0;
        //计算周长
        for (int num : nums) {
            C += num;
        }
        if (C == 0 || C % 4 != 0) {
            return false;
        }

        //边长
        int a = C / 4;

        for (int num : nums) {
            if (num > a) {
                return false;
            }
        }

        Arrays.sort(nums);
        helper(nums.length - 1, nums, a, new int[4]);

        return res;
    }

    private void helper(int cur, int[] nums, int a, int[] temp) {
        if (res) {
            return;
        }
        if (cur == -1) {
            for (int num : temp) {
                if (num != a)
                    return;
                res = true;
                return;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            int last = temp[i];
            temp[i] += nums[cur];
            if (temp[i] <= a) {
                helper(cur - 1, nums, a, temp);
            }
            temp[i] = last;
        }
    }
}
