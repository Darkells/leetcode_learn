package Medium;

/**
 * @author Dark
 * @2019/10/10 20:10
 */
public class NthUglyNumber {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (min == dp[p2] * 2) p2++;
            if (min == dp[p3] * 3) p3++;
            if (min == dp[p5] * 5) p5++;
            dp[i] = min;
        }
        return dp[n - 1];
    }
}
