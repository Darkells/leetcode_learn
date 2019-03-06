package Primary_code.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dark
 * @date 2019/3/6 9:44
 */

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //定义两个指针
        int p1 = 0, p2 = 0;
        List<Integer> list = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            int num1 = nums1[p1];
            int num2 = nums2[p2];
            /*
             *1、m == n，则该数字是重复数字，将该数字添加到结果数组中，同时将两个指针分别后移一位。
             *2、m > n，我们需要将c2指针后移一位。
             *3、m < n，我们需要将c1指针后移一位。
             */
            if (num1 == num2) {
                list.add(num1);
                p1++;
                p2++;
            } else if (num1 < num2) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
