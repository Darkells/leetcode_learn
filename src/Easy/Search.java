package Easy;

/**
 * @author Dark
 * @date 2019/5/20 8:50
 */
public class Search {
    public int search(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int index = start + (end - start) / 2;
            if (target == nums[index]){
                return index;
            }else if (target > nums[index]){
                start = index + 1;
            }else {
                end = index + 1;
            }
        }
        return -1;

    }
}
