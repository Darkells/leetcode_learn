package Easy;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(nums[i])) {
                ht.put(nums[i], ht.get(nums[i]) + 1);
                if (ht.get(nums[i]) > nums.length / 2) {
                    return nums[i];
                }
            } else {
                ht.put(nums[i], 1);
            }
        }
        return 0;
    }

    public static int find(int[] nums, int begin, int end) {
        //当数组长度为1时
        if (begin == end) {
            return nums[begin];
        }
        //分而治之
        int mid = nums.length / 2;
        int left = find(nums, begin, mid);
        int right = find(nums, mid + 1, end);
        if (left == right){
            return left;
        }else {
            int leftcount = 0,rightcount = 0;
            for (int i = begin;i < end;i++){
                if (nums[i] == left){
                    leftcount++;
                }else if (nums[i] == right){
                    rightcount++;
                }
            }
            if (leftcount >= rightcount){
                return left;
            }else {
                return right;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(1 / 2);
    }
}
