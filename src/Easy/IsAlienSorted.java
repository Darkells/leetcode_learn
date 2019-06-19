package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verifying-an-alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/6/18 10:16
 */
public class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        boolean flag = true;
        for (int i = 0; i < words.length-1; i++) {
            char[] wb1 = words[i].toCharArray();
            char[] wb2= words[i+1].toCharArray();
            if(words[i].length()<words[i+1].length()){
                for (int j = 0; j < words[i].length(); j++) {
                    if(order.indexOf(wb1[j])<order.indexOf(wb2[j])){
                        break;
                    }else if(order.indexOf(wb1[j])>order.indexOf(wb2[j])){
                        flag =false;
                        break;
                    }
                }
            }else{
                for (int j = 0; j < words[i+1].length(); j++) {
                    if(order.indexOf(wb1[j])<order.indexOf(wb2[j])){
                        break;
                    }else if(order.indexOf(wb1[j])>order.indexOf(wb2[j])){
                        flag =false;
                        break;
                    }if(j+1== words[i+1].length()){
                        flag =false;
                    }
                }
            }
        }
        return flag;
    }

    public boolean isAlienSorted2(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = order.toCharArray();
        int i = 0;
        for (char c : chars) {
            map.put(c,i++);
        }
        for (i = 0; i < words.length - 1; i++) {
                int k = 0;
                int m = 0;
                int len1 = words[i].length();
                int len2 = words[i+1].length();
                while(k<len1&&m<len2){
                    int c1=map.get(words[i].charAt(k));
                    int c2=map.get(words[i+1].charAt(m));

                    if(c1>c2)return false;
                    else if(c1<c2)break;

                    k++;
                    m++;
                if(k!=len1&&m==len2)return false;
            }
        }
        return true;
    }
}
