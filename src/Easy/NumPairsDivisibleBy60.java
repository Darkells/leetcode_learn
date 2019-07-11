package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 *
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/7/11 16:03
 */
public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        // 预处理：把数组中的元素全都模 60
        int len = time.length;
        for (int i = 0; i < len; i++) {
            time[i] = time[i] % 60;
        }
        // 注意：[60, 60, 60] 会被处理成 [0, 0, 0]
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 注意：要记得模 60
            int residue = (60 - time[i]) % 60;

            Integer preCount = map.get(residue);
            if (preCount != null) {
                res += preCount;
            }

            // 计数，应该放在统计之后做，因为后面的参考前面的
            Integer curCount = map.get(time[i]);
            if (curCount == null) {
                map.put(time[i], 1);
            } else {
                map.put(time[i], curCount + 1);
            }
        }
        return res;
    }


    public int numPairsDivisibleBy602(int[] time){
        int res = 0;
        int[] times = new int[60];
        for (int i : time) {
            res += times[(60 - i % 60) % 60];
            times[i % 60]++;
        }

        return res;
    }
}
