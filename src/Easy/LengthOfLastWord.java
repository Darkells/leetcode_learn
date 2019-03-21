package Easy;

/**
 * @author Dark
 * @date 2019/3/21 22:07
 */

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int num = 0;
        int i = s.length() - 1;
        if (s.length() == 0){
            return num;
        }
        //处理尾部为空格的字符串
        while (s.charAt(i) == ' '){
            i--;
            //排除空格字符串
            if (i < 0){
                return num;
            }
        }

        for (;i >= 0;i--){
            //计算最后一个单词的字母
            if (s.charAt(i) == ' '){
                break;
            }
            num++;
        }
        return num;
    }
}
