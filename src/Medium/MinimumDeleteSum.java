package Medium;

import java.util.Arrays;

/**
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 *
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 注意:
 *
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class MinimumDeleteSum {
    /**
     * 求两个字符串的最小ASCII删除和：意求两个字符串最大ASCII公共子序列
     * dp[i][j] 意味两个字符串对于i，j
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int total_sum = 0;
        if (M == 0 || N == 0) {
            return total_sum;
        }

        for (int i = 0; i < M; i++) {
            total_sum += s1.charAt(i);
        }

        for (int j = 0; j < N; j++) {
            total_sum += s2.charAt(j);
        }

        int[][] common_sum = new int[M + 1][N + 1];

        int max_common_sum = 0;
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    common_sum[i][j] = common_sum[i-1][j-1] + s1.charAt(i - 1);
                } else {
                    common_sum[i][j] = Math.max(common_sum[i-1][j], common_sum[i][j-1]);
                }
                max_common_sum = Math.max(max_common_sum, common_sum[i][j]);
            }
        }
        return total_sum - 2*max_common_sum;
    }
}
