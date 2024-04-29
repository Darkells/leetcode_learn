package New2024.Daily;

/*
Make Costs of Paths Equal in a Binary Tree
 */
public class Daily0228 {
    public static int minIncrements(int n, int[] cost) {
        int res = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            res += Math.abs(cost[i] - cost[i+1]);
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return res;
    }
}
