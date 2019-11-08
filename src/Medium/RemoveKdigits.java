package Medium;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/11/8 14:28
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int index = 0;
            for (int j  = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j - 1); j++){
                index = j;
            }
            sb.delete(index, index + 1);
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.delete(0,1);
            }
        }
        return sb.toString();
    }

    public String removeKdigits2(String num, int k) {
        //贪心算法 + 单调栈
        if (k >= num.length() || num.length() == 0) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            if (c != '0' || !stack.isEmpty()) {
                stack.push(c);
            }
        }

        while (k > 0) {
            k--;
            stack.pop();
        }

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
