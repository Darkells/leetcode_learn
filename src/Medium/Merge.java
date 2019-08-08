package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/8/8 14:51
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals,(Comparator.comparingInt(o -> o[0])));
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] <= intervals[i][1]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        //最后的区间加入list中
        list.add(intervals[intervals.length - 1]);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    public int[][] merge2(int[][] arr) {
        //当数组长度小于2，直接返回
        if (arr.length < 2) {
            return arr;
        }

        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int l = 0;
        int r = arr.length;
        while (l < r) {
            //定义区间的左右边界
            int left = arr[l][0];
            int right = arr[l][1];
            //当相邻区间的左边界小于当前区间的右边界 合并，取相对较大的右边界
            while (l < r - 1 && right >= arr[l + 1][0]) {
                right = Math.max(right,arr[l + 1][1]);
                l++;
            }
            list.add(new int[] {left,right});
            l++;
        }

        return list.toArray(new int[list.size()][2]);
    }
}
