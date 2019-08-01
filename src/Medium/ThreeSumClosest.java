package Medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/7/27 16:08
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //先排序，遍历+双指针
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int start = 0,end = 0,sum = 0;
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                //如果sum与target的距离更近 res赋值为sum
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return res;
                }
            }
        }

        return res;
    }
}
