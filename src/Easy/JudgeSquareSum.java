package Easy;

/**
 * @author Dark
 * @date 2019/5/9 8:59
 */

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        //假设 b >= a, b^2 <= c, a↑ b↓
        int b = (int) Math.sqrt(c), a = 0;
        while(a <= b){
            int sum = a*a + b*b;
            if(sum == c){
                return true;
            }else if(sum > c){
                b--;
            }else{
                a++;
            }
        }
        return false;
    }
}
