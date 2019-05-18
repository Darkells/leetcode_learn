package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dark
 * @date 2019/5/14 14:31
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int minVal = Integer.MIN_VALUE;
        int cnts = 0, ants = 0;

        for(int i=0; i < nums.length; i++){
            if(nums[i] > minVal){
                cnts++;
            }else{
                ants = Math.max(ants,cnts);
                cnts = 1;
            }

            minVal = nums[i];
        }
        return Math.max(ants,cnts);
    }
}
