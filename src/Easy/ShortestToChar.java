package Easy;

/**
 * @author Dark
 * @date 2019/6/5 8:42
 */

/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 *
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 */
public class ShortestToChar {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] left = new int[len];
        int[] right = new int[len];
        //左指针从左遍历
        left[0] = S.charAt(0) == C ? 0 : 10000;
        for (int i = 1; i < len; i++) {
            left[i] = S.charAt(i) == C ? 0 : left[i - 1] + 1;
        }
        //右指针从右遍历
        right[len - 1] = S.charAt(len - 1) == C ? 0 : 10000;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = S.charAt(i) == C ? 0 : right[i + 1] + 1;
        }
        //留下最小值
        for (int i = 0; i < len; i++) {
            left[i] = Math.min(left[i], right[i]);
        }
        return left;
    }
}
