package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAnagrams {
    //超时做法
    public static List<Integer> findAngrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length(); i++) {
            String temp = s.substring(i, i + p.length());
            if (sumString(temp) == sumString(p)) {
                list.add(i);
            }
        }
        return list;
    }
    public static int sumString(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result += c;
        }
        return result;
    }

    public List<Integer> findAngrams2(String s,String p){
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()){
            return list;
        }
        int[] sc = new int[26];
        int[] pc = new int[26];
        for (int i = 0; i < p.length();i++){
            sc[s.charAt(i) - 'a']++;
            pc[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sc,pc)){
            list.add(0);
        }
        for (int i = p.length();i < s.length(); i++){
            sc[s.charAt(i - p.length() - 'a')]--;
            sc[s.charAt(i) - 'a']++;
            if (Arrays.equals(sc,pc)){
                list.add(i - p.length() + 1);
            }
        }
        return list;
    }
}
