package Primary_code.String;

/**
 * @author Dark
 * @date 2019/3/8 14:00
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    /**
     * 第一种算法：利用哈希表记录26个字母出现的次数，做对比。次数相同 返回true 不同返回 false
     * 对比可以 立定榜样
     * 第二种算法：暴力破解 转换为字符数组，利用排序。遍历对比
     * 第三种算法：可以使用ascii解决
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t){
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        String s2 = new String(s1);
        String t2 = new String(t1);
        if (s2.equals(t2)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isAnagram2(String s, String t){
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        if (s1.length != t1.length){
            return false;
        }else if (s1.length == 0 && t1.length == 0){
            return true;
        }
        for(int i=0;i<s1.length;i++){
            if(map.containsKey(s1[i])){
                map.put(s1[i],map.get(s1[i])+1);
            }else{
                map.put(s1[i],1);
            }
        }
        for(int i=0;i<t1.length;++i){
            if(map.containsKey(t1[i])){
                map.put(t1[i],map.get(t1[i])-1);
            }else{
                return false;
            }
        }

        if (map.get(s1[0])!=0)
            return false;
        return true;

    }

    public boolean isAnagram3(String s, String t) {
        //刚开始想的是用s - t字符的ascii码 出现平均的字符就不通过了 例如 'ac' 和 'bb'
        if(s.length()!=t.length())
            return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            count[t.charAt(i) - 'a']--;
        for (int i : count)
            if (i != 0)
                return false;
        return true;
    }
}
