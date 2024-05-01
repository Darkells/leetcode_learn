package New2024.Daily.May;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

You will run k sessions and hire exactly one worker in each session.
In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
A worker can only be chosen once.
Return the total cost to hire exactly k workers.
 */


public class Daily0501 {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (2 * candidates + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }

        // 初始化两个最小堆
        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();

        for (int i = 0; i < candidates; i++) {
            pre.add(costs[i]);
            suf.add(costs[n - 1 - i]);
        }

        int i = candidates, j = n - 1 - candidates;

        int temp = 0;

        // 循环k次选取最小元素
        for (int round = 0; round < k; round++) {
            temp++;
            if (pre.peek() <= suf.peek()) {
                ans += pre.poll();
                if (i < j) {
                    pre.add(costs[i++]);
                }
            } else {
                ans += suf.poll();
                if (i < j) {
                    suf.add(costs[j--]);
                }
            }
        }

        return ans;
    }
}
