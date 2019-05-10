package Easy;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class FindMaxAverage {
    //超时解法
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1){
            return nums[0];
        }
        double max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++){
            double temp = 0;
            for (int j = i;j < i + k; j++){
                temp += nums[j];
            }
            if (temp > max){
                max = temp;
            }
        }
        return max / k;
    }
    //滑窗解法
    public double findMaxAverage2(int[] nums,int k) {
        double max=0;
        //滑窗
        for(int i=0;i<k;i++){
            max=max+nums[i];
        } //初始化最大值

        double max1=max;
        double max2=0;
        for(int i=1;i<nums.length-k+1;i++){
            max2=max1-nums[i-1]+nums[i+k-1];
            if (max2>max){
                max=max2;
            }
            max1=max2;
        }
        return ((double)max)/k;
    }
}
