package Medium;

import java.util.HashMap;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstring {
    private int re = 0;
    public int longestSubstring(String s, int k) {
        if (s.length() == 0) return 0;
        getlonggest(s,k);
        return re;
    }

    public void getlonggest(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int l = 0;
        boolean greater = true;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                if (i > l) getlonggest(s.substring(l,i), k);
                greater = false;
                l = i + 1;
            }
        }

        if (!greater && s.length() > l) getlonggest(s.substring(l, s.length()), k);
        if (greater) {
            re = Math.max(re, s.length());
        }
    }


    public int longestSubstring2(String s, int k) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            int j = i;
            if (map.get(s.charAt(i)) < k) {
                for (; j < s.length(); j++) {
                    if (s.charAt(j) != s.charAt(i)) break;
                }
                return Math.max(longestSubstring2(s.substring(0,i),k),longestSubstring2(s.substring(j),k));
            }
        }

        return s.length();
    }


    public int longestSubstring3(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;

        return count(s.toCharArray(), k, 0, len - 1);
    }

    private static int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k) return 0;
        int[] times = new int[26];  //  26个字母
        //  统计出现频次
        for (int i = p1; i <= p2; ++i) {
            ++times[chars[i] - 'a'];
        }
        //  如果该字符出现频次小于k，则不可能出现在结果子串中
        //  分别排除，然后挪动两个指针
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k) {
            ++p1;
        }
        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k) {
            --p2;
        }

        if (p2 - p1 + 1 < k) return 0;
        //  得到临时子串，再递归处理
        for (int i = p1; i <= p2; ++i) {
            //  如果第i个不符合要求，切分成左右两段分别递归求得
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }
}
