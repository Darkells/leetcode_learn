package Medium;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        //这样就不用初始化最底层
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0;i --) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                //状态转移方程可以看中间某行第一个数为例，例如 6 , dp[0] = 下一层min(dp[0],dp[1]) + 6
                dp[j] = Math.min(dp[j],dp[j + 1]) + cur.get(j);
            }
        }

        return dp[0];
    }
}
