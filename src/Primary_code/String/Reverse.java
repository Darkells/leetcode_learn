package Primary_code.String;

/**
 * @author Dark
 * @date 2019/3/7 0:43
 */

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {
    public static int reverse(int x) {
        int a,res = 0;
        int max = (int)Math.pow(2,31);
        int min = (int)Math.pow(-2,31);
        while (x != 0){
            a = x % 10;
            x /= 10;
            if (res > max/10 || (res == max / 10 && a > 7))
                return 0;
            if (res < min/10 || (res == min / 10 && a < -8))
                return 0;
            res = res * 10 + a;
        }
        return res;
    }
    public static void main(String[] args){
        int num1 = 123;
        int num2 = -123;
        System.out.println(reverse(num1) +" " + reverse(num2));
    }
}
