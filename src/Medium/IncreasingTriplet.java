package Medium;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= i) {
                i = num;
            } else if (num <= j) {
                j = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
