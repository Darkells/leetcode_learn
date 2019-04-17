package Easy;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class GetSum {
    public int getSum(int a, int b) {
        int sum = 0, carry = 0;
        //没有显示进位
        sum = a ^ b;
        //记录进位
        carry = (a & b) << 1;
        if (carry != 0) {
            return getSum(sum, carry);
        }
        return sum;
    }
}
