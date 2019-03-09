package Primary_code.String;

/**
 * @author Dark
 * @date 2019/3/9 14:38
 */

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s){
        if(s == null || s.length()==0){
            return true;
        }
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        StringBuilder result=new StringBuilder();
        for (int i = 0;i < c.length;i++){
            if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= '0' && c[i] <= '9')){
                result.append(c[i]);
            }
        }
        int head = 0;
        int end = result.length()-1;
        while(head < end){
            if(result.charAt(head)!=result.charAt(end))
                return false;
            else{
                head++;
                end--;
            }
        }
        return true;
    }

    //首先要把字符挑选出来,一种是上述那种方法
    //另外一个是取一半，反转对比
}
