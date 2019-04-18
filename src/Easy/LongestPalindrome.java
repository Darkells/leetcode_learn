package Easy;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {
    //排行第一的解法
    public int longestPalindrome(String s){
        int[] in = new int[128];
        for (char c : s.toCharArray()){
            in[c]++;
        }
        int max = 0;
        for(int i : in){
            max += (i / 2) * 2;
        }
        if (max < s.length()){
            max++;
        }
        return max;
    }
    public int longestPalindrome2(String s){
        boolean[] in = new boolean[128];
        int max = 0;
        for (char c : s.toCharArray()){
            in[c] = !in[c];
            if (!in[c]){
                max += 2;
            }
        }
        if (max < s.length()){
            max++;
        }
        return max;
    }
}
