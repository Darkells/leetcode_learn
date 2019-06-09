package Easy;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 * <p>
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 * <p>
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 * <p>
 * 输入： A = "", B = "aa"
 * 输出： false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Dark
 * @date 2019/6/8 9:02
 */
public class BuddyStrings {
    public boolean buddyString(String A, String B) {
        //长度不同
        if (A.length() != B.length()) {
            return false;
        }
        //当A==B时
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); i++) {
                count[A.charAt(i) - 'a']++;
            }
            for (int c : count) {
                //当有重复的字母就为亲密字符串
                if (c > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j)) {
                    if (first == -1) {
                        first = j;
                    } else if (second == -1) {
                        second = j;
                    } else {
                        return false;
                    }
                }
            }
            return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));

        }
    }
}
