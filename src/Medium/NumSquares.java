package Medium;

/**
 * @author Dark
 * @2019/10/10 20:33
 */
public class NumSquares {

    private int[] dp;
    public int numSquares(int n) {
        dp = new int[n + 1];
        return sum(n);
    }

    private int sum(int n){
        //dp里面必有数据
        if (dp[n] != 0) {
            return dp[n];
        }
        //检测n是否为完全平方数
        int val = (int) Math.sqrt(n);
        if (val * val == n) {
            return dp[n] = 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            min = Math.min(min,dp[n - i*i] + 1);
        }
        dp[n] = min;
        return dp[n];
    }


    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //最坏情况就是i
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(i,dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
