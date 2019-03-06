package Primary_code.Array;

import java.util.Arrays;

/**
 * @author Dark
 * @date 2019/3/6 9:35
 */

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber {
    //在不使用额外的空间就是使用空间复杂度为O(1)的原地算法
    public int singleNumber(int[] nums) {
        //最初的想法
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }
        return nums[nums.length - 1];
    }

    public static int singleNumber2(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
    /**
     * ---------------------
     *     作者：风追云影
     *     来源：CSDN
     *     原文：https://www.cnblogs.com/zfLee/p/9330127.html
     *     版权声明：本文为博主原创文章，转载请附上博文链接！
     * @param args
     */
}
