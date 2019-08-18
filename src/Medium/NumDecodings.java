package Medium;

/**
 * @author Dark
 * @2019/8/15 16:01
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            //如果该位不为‘0’，说明该位但单独成字母合法
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
