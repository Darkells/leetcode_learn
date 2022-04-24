package Primary_code.Array;

/**
 * @author Dark
 * @date 2019/3/6 9:29
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ContainsDuplicate {
    //利用set的属性可以直接解决
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums){
            //Set.add(Object)添加失败会返回false
            if(!set.add(a)) {
                return true;
            }
        }
        return false;
    }
    //直接运算法
    public static boolean containsDuplicate2(int[] nums){
        for (int i = 0;i < nums.length;++i){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] s = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate2(s));
    }
}
