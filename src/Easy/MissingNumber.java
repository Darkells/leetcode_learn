package Easy;

import java.util.Arrays;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {
    //此方法不建议，本着不使用调用封装好的api方法
    public int missingNumber(int[] nums){
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums){
        int sum = nums.length;
        for (int i = 0;i < nums.length;i++){
            sum ^= nums[i];
            sum ^= i;
        }
        return sum;
    }

    public int missingNumber3(int[] nums){
        int num = (1+nums.length) / 2;
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        return num - sum;
    }
}
