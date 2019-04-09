package Easy;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //查看map里是否有存在s的键值对应关系,没有的话
            if (!map.containsKey(s.charAt(i))) {
                //如何以存在对于t的值，说明映射结构不同
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        //因为asclii码最大是128
        int[] smap = new int[128];
        int[] tmap = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (smap[s.charAt(i)] != tmap[t.charAt(i)]) {
                return false;
            }
            smap[s.charAt(i)] = i + 1;
            tmap[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
