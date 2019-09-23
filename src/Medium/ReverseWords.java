package Medium;

import java.util.Stack;

/**
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/9/22 15:05
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        if(s == null || s.equals("")) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    while (!stack.isEmpty()) {
                        res.append(stack.pop());
                    }
                    if(i != 0) {
                        res.append(" ");
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            res.deleteCharAt(res.length() - 1);
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        if (res.length() == 0) {
            return "";
        }
        return res.toString();
    }
}
