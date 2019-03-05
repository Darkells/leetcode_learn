package Primary_code;

/**
 * @author Dark
 * @date 2019/3/6 0:01
 */

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class Rotate {
    public static int[] rotate1(int[] nums,int k){
        int[] a = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            if (i+k < nums.length){
                a[i+k] = nums[i];
            }else {
                a[i+k-nums.length] = nums[i];
            }
        }
        return a;
    }


    //此为借鉴算法
    public static int[] rotate(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0) {
            return nums;
        }
        int length = nums.length;
        int start = 0;
        int i = 0;
        int cur = nums[i];
        int cnt = 0;

        while (cnt++ < length) {
            i = (i + k) % length;
            int t = nums[i];
            nums[i] = cur;
            if (i == start) {
                ++start;
                ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
        return nums;
    }

    /**
     * ---------------------
     *     作者：别志华
     *     来源：CSDN
     *     原文：https://blog.csdn.net/biezhihua/article/details/79535021
     *     版权声明：本文为博主原创文章，转载请附上博文链接！
     * @param args
     */
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int[] a = rotate1(nums,3);
        for (int i : a
             ) {
            System.out.println(i);
        }
    }


}
