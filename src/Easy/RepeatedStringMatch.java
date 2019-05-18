package Easy;

/**
 * @author Dark
 * @date 2019/5/18 9:25
 */

/**
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 * <p>
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * <p>
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 * <p>
 * 注意:
 * <p>
 * A 与 B 字符串的长度在1和10000区间范围内。
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int max = 2 * A.length() + B.length();
        StringBuilder sb = new StringBuilder(A);
        int len = 1;
        while (len <= max){
            if (sb.lastIndexOf(B) > -1){
                return len / A.length();
            }else{
                sb.append(A);
                len += A.length();
            }
        }
        return -1;
    }
}
