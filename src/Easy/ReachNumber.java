package Easy;

/**
 * @author Dark
 * @date 2019/5/28 8:55
 */

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * <p>
 * 返回到达终点需要的最小移动次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 * 示例 2:
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * 注意:
 * <p>
 * target是在[-10^9, 10^9]范围中的非零整数
 */
public class ReachNumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int i = 0;
        while (true) {
            sum += i;
            if (sum >= target && (sum - target) % 2 == 0) {
                return i;
            }
            i += 1;
        }
    }
}
