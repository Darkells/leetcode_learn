package Easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 *
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 1;
        for (int i = nums2.length - 1; i >= 0 ;i--){
            map.put(nums2[i],index);
            index++;
        }

        String[] s = new String[nums.length];
        for (int j = 0;j <nums.length;j++){
            if (map.get(nums[j]) == 1){
                s[j] = "Gold Medal";
            }else if (map.get(nums[j]) == 2){
                s[j] = "Silver Medal";
            }else if (map.get(nums[j]) == 3){
                s[j] = "Bronze Medal";
            }else{
                s[j] = "" + map.get(nums[j]);
            }
        }
        return s;
    }
}
