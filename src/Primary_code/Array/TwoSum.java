package Primary_code.Array;

/**
 * @author Dark
 * @date 2019/3/9 15:14
 */

/**
 *
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int[] a = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }
}
