package Easy;

/**
 * @author Dark
 * @date 2019/3/20 22:07
 */

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

/**
 * 暴力破解篇
 * 从头到尾划分子数组
 */
public class MaxSubArray {
    //自定义一个最小的最大值
    private static int max = Integer.MIN_VALUE;
    public static int maxSubArray(int[] nums){
        int sum;
        for(int i = 0;i < nums.length;i++){
            //每次循环重置sum的值
            sum = 0;
            for (int j = i;j < nums.length;j++){
                sum += nums[j];
                if (sum > max){
                  max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 分而治之法
     * 递归搬运学习
     *
     * ---------------------
     *                 作者：fengpojian
     *         来源：CSDN
     *         原文：https://blog.csdn.net/fengpojian/article/details/82788752
     * @param args
     */
    public static int maxSubArray02(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        for(int i=1; i<nums.length; i++){
            local = Math.max(nums[i], local+nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
