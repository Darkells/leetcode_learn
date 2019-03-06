package Primary_code.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dark
 * @date 2019/3/7 0:04
 */

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    //暴力搜索 时间复杂度最大
    public static int firstUniqChar(String s){
        char[] a = s.toCharArray();
        for (int i = 0;i < a.length;i++){
            boolean t = true;
            for (int j = 0;j < a.length;j++){
                if (i != j && a[i] == a[j]){
                    t = false;
                    break;
                }
            }
            if (t == true){
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s){
        //遍历记录到HashMap里，统计每种字符出现的次数，查找出值为1对应的key
        char[] c = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>(s.length()); //预先分配大小,避免扩容性能影响
        for (int i = 0; i < c.length; i++) {
            if (!charMap.containsKey(c[i])){
                charMap.put(c[i], 1);
            }else {
                charMap.put(c[i], charMap.get(c[i])+1);
            }
        }

        for (int i = 0; i < c[i]; i++) {
            if (charMap.get(c[i]) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String s1 = "leetcode";
        String s2 = "iqwertyupolkjhagfmnbvcxzdsa";
        System.out.println(firstUniqChar2(s1));
        System.out.println(firstUniqChar2(s2));
    }
}
