package Easy;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */


public class TrailingZeroes {
    public int trailingZeroes(int n){
        if (n < 5){
            return 0;
        }
        int count = n / 5;
        return count + trailingZeroes(count);
    }
}
