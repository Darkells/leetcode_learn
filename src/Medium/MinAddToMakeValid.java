package Medium;

import java.util.Stack;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："())"
 * 输出：1
 * 示例 2：
 *
 * 输入："((("
 * 输出：3
 * 示例 3：
 *
 * 输入："()"
 * 输出：0
 * 示例 4：
 *
 * 输入："()))(("
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinAddToMakeValid {
    public int minAddToMakeValid(String S) {
        int left = 0;
        int right = 0;
        for (char c : S.toCharArray()) {
            if ('(' == c) {
                left++;
            } else if (left > 0){
                left--;
            } else {
                right++;
            }
        }

        return left + right;
    }

    public int minAddToMakeValid2(String S) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            }else {
                stack.add(c);
            }
        }
        return stack.size();
    }
}
