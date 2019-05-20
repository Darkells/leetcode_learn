package Easy;

/**
 * @author Dark
 * @date 2019/5/20 8:07
 */

import java.util.HashMap;
import java.util.Set;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * <p>
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */
public class FindShortestSubArray {
    public int findShorttestSubArray(int[] nums) {
        int maxCount = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                int temp = map.get(n) + 1;
                map.put(n, temp);
                if (maxCount < temp) {
                    maxCount = temp;
                }
            } else {
                map.put(n, 1);
            }
        }
        Set<Integer> set = map.keySet();
        int minDis = Integer.MAX_VALUE;
        for (int n : set) {
            int temp = Integer.MAX_VALUE;
            if (map.get(n) == maxCount) {
                int i = 0, j = nums.length - 1;
                while (nums[i] != n && i < j) {
                    i++;
                }
                while (nums[j] != n && i < j) {
                    j--;
                }
                temp = j - i + 1;
            }
            minDis = Math.min(temp, minDis);
        }
        return minDis;
    }

    //快速解法
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] mapSize = new int[max+1];
        int[] mapMin = new int[max+1];
        int[] mapMax = new int[max+1];
        int maxSize = 1;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(mapSize[num] == 0){
                mapMin[num] = i;
                mapMax[num] = i;
            }else{
                mapMax[num] = i;
            }
            maxSize = Math.max(maxSize, ++mapSize[num]);
        }
        int ans = Integer.MAX_VALUE;
        for(int num = 0; num <= max; num++){
            if(maxSize == mapSize[num]){
                ans = Math.min(ans, mapMax[num] - mapMin[num] + 1);
            }
        }
        return ans;

    }
}
