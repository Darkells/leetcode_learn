package Primary_code.String;

/**
 * @author Dark
 * @date 2019/3/12 12:11
 */

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        int sign = 1, base = 0, i = 0, INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;

        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (i >= str.length())
            return 0;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > INT_MAX / 10 || (base == INT_MAX / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == -1)
                    return INT_MIN;
                else
                    return INT_MAX;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }

        return base * sign;
    }

    public static int myAtoi2(String str) {
        if (str.equals("")) {
            return 0;
        }
        char[] c = str.toCharArray();
        int sign = 1, sum = 0, i = 0;
        while (i < c.length && c[i] == ' ') {
            i++;
        }
        if (i == c.length)
            return 0;
        if (c[i] == '-' || c[i] == '+') {
            if (c[i] == '-')
                sign = -1;
            i++;
        }
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && c[i] - '0' > 7)) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            sum = 10 * sum + (c[i++] - '0');
        }
        return sum * sign;
    }

    public static void main(String[] args) {
        String str = "+1";
        System.out.println(myAtoi(str) + " " + myAtoi2(str));
    }
}
