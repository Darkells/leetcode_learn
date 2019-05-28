package Easy;

/**
 * @author Dark
 * @date 2019/5/27 14:05
 */

import java.util.HashMap;

/**
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 * <p>
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 * <p>
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 * <p>
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
 * <p>
 * <p>
 * 注意:
 * <p>
 * 牌照（licensePlate）的长度在区域[1, 7]中。
 * 牌照（licensePlate）将会包含数字、空格、或者字母（大写和小写）。
 * 单词列表（words）长度在区间 [10, 1000] 中。
 * 每一个单词 words[i] 都是小写，并且长度在区间 [1, 15] 中。
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' <= 26) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (String word : words) {
            map2.putAll(map);
            if (word.length() < min) {
                for (char ch : word.toLowerCase().toCharArray()) {
                    if (map2.containsKey(ch)) {
                        map2.put(ch, map2.get(ch) - 1);
                        if (map2.get(ch) == 0) {
                            map2.remove(ch);
                        }
                    }

                }
                if (map2.isEmpty()) {
                    res = word;
                    min = word.length();
                }
            }
        }
        return res;
    }

    public String shortestCompletingWord2(String licensePlate, String[] words) {
        String res = "";
        int[] nums = new int[26];
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (ch - 'a' >= 0 && ch - 'a' <= 26) {
                nums[ch - 'a']++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() < min) {
                int[] d = new int[26];
                // 统计单词列表中的各个单词 每个字符的数量
                for (char ch : word.toLowerCase().toCharArray()) {
                    d[ch - 'a']++;
                }
                boolean flag = true;
                // licensePlate 各个字符的数量一定要小于words
                for (int i = 0; i < 26; i++) {
                    if (nums[i] > d[i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    res = word;
                    min = word.length();
                }
            }
        }
        return res;
    }
}
