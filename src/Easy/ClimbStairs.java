package Easy;

/**
 * @author Dark
 * @date 2019/3/23 18:34
 */

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 题目很明显的表示 斐波那契数列
 * 就是叫你打印 斐波那契数列 利用尾递归会比较好
 */
public class ClimbStairs {
    //递归  超时
    public static int climbStairs01(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs01(n - 1) + climbStairs01(n - 2);
    }

    //就是想用递归
    public static int climbStairs02(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        climb(nums,n);
        return nums[n];
    }

    //不超时
    public static void climb(int[] nums, int n) {
        int x = n - 1;
        int y = n - 2;
        if (x > 2 && nums[x] == 0)
            climb(nums, x);
        if (y > 2 && nums[y] == 0)
            climb(nums, y);
        nums[n] = nums[x] + nums[y];
    }

    public static int climbStairs03(int n) {
        return lastFibonacci(n+2,0,1);
    }

    public static int lastFibonacci(int n, int ret1, int ret2) {
        if(n == 1) {
            return ret1;
        }
        return lastFibonacci(n - 1, ret2, ret1 + ret2);
    }
}
