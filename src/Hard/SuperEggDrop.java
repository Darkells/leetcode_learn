package Hard;

import java.util.Arrays;

public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K];
        while (dp[K - 1] < N) {
            for (int k = K - 1; k >= 1; k++) {
                dp[k] = dp[k] + dp[k - 1] + 1;
            }
            dp[0]++;
        }

        return dp[0];
    }

    public int superEggDrop2(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m -1] + dp[k-1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
}
