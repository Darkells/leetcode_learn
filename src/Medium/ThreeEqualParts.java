package Medium;

import java.util.Arrays;

/**
 * 给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。
 * <p>
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * <p>
 * A[0], A[1], ..., A[i] 组成第一部分；
 * A[i+1], A[i+2], ..., A[j-1] 作为第二部分；
 * A[j], A[j+1], ..., A[A.length - 1] 是第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 * <p>
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,1,0,1]
 * 输出：[0,3]
 * 示例 2：
 * <p>
 * 输出：[1,1,0,1,1]
 * 输出：[-1,-1]
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 30000
 * A[i] == 0 或 A[i] == 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] A) {
        //默认初始化为{-1,-1}
        int[] res = {-1, -1};

        int N = A.length;
        //数组中1的个数
        int S = 0;
        for (int x : A) {
            S += x;
        }
        //1的个数不为3的倍数 无法做到
        if (S % 3 != 0) {
            return res;
        }

        int T = S / 3;
        if (T == 0) {
            return new int[]{0, N - 1};
        }

        int i1 = 0, j1 = 0, i2 = 0, j2 = 0, i3 = 0, j3 = 0;
        int su = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 1) {
                su++;
                if (su == 1) i1 = i;
                if (su == T) j1 = i;
                if (su == T + 1) i2 = i;
                if (su == 2 * T) j2 = i;
                if (su == 2 * T + 1) i3 = i;
                if (su == 3 * T) j3 = i;
            }
        }

        int[] part1 = Arrays.copyOfRange(A, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(A, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(A, i3, j3+1);

        if (!Arrays.equals(part1, part2)) return res;
        if (!Arrays.equals(part1, part3)) return res;

        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = A.length - j3 - 1;

        if (x < z || y < z) return res;
        return new int[]{j1+z, j2+z+1};
    }
}
