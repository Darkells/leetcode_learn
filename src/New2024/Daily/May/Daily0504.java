package New2024.Daily.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
1235. Maximum Profit in Job Scheduling
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */

public class Daily0504 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // 根据工作的结束时间对工作进行排序
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        // 使用ArrayList来存储[结束时间, 目前最大收益]
        ArrayList<int[]> dp = new ArrayList<>();
        dp.add(new int[] {0, 0});  // 初始化，没有工作时收益为0

        int curStart, curEnd, curProfit, pos, maxProfit;
        for (int[] job : jobs) {
            curStart = job[0];
            curEnd = job[1];
            curProfit = job[2];

            // 二分查找最后一个结束时间小于当前工作开始时间的工作的位置
            pos = binarySearch(dp, curStart + 1);
            maxProfit = dp.get(pos)[1] + curProfit;

            // 只有当当前工作能带来更高的收益时才添加到dp中
            if (maxProfit > dp.get(dp.size() - 1)[1]) {
                dp.add(new int[] {curEnd, maxProfit});
            }
        }

        // 最后一个元素的第二个值就是最大收益
        return dp.get(dp.size() - 1)[1];
    }

    private static int binarySearch(ArrayList<int[]> dp, int target) {
        int low = 0, high = dp.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (dp.get(mid)[0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
