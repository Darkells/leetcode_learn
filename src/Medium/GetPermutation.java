package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Dark
 * @2019/8/9 14:07
 */

/**
 * 解题思路
 * n 个数字有 n！种全排列，每种数字开头的全排列有 (n - 1)!种。
 * 所以用 k / (n - 1)! 就可以得到第 k 个全排列是以第几个数字开头的。
 * 用 k % (n - 1)! 就可以得到第 k 个全排列是某个数字开头的全排列中的第几个。
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        int[] pax = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        k = k - 1;
        while(n != 0) {
            int a = k / pax[n - 1];
            int r = k % pax[n - 1];
            if (a < list.size()) {
                sb.append(list.get(a));
                list.remove(a);
            }
            k = r;
            n--;
        }

        return sb.toString();
    }
}
