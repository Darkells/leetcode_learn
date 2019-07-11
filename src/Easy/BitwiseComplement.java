package Easy;

/**
 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 *
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 *
 * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：5
 * 输出：2
 * 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
 * 示例 2：
 *
 * 输入：7
 * 输出：0
 * 解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
 * 示例 3：
 *
 * 输入：10
 * 输出：5
 * 解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complement-of-base-10-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/7/11 15:06
 */
public class BitwiseComplement {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 1; N > 0;) {
            res += ((N&1)^1) * i;
            N >>= 1;
            i = i * 2;
        }

        return res;
    }

    public int bitwiseComplement2(int N) {
        int i = 1;
        int ret = ~N;

        if(N == 0)
            return 1;

        while(N > 0) {
            N >>= 1;
            i <<= 1;
        }
        i -= 1;
        return ret & i;
    }
}
