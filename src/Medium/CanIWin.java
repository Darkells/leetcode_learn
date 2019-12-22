package Medium;

import java.util.HashMap;

/**
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
 *
 * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
 *
 * 示例：
 *
 * 输入：
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * 输出：
 * false
 *
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-i-win
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        HashMap<Integer, Boolean> map = new HashMap<>();
        return canWin(maxChoosableInteger,desiredTotal,0,map);

    }

    private boolean canWin(int length, int total, int used, HashMap<Integer, Boolean> map) {
        if (map.containsKey(used))  return map.get(used);
        for (int i = 0; i < length; i++) {
            int cur = 1 << i;
            if ((cur & used) == 0) {
                if (total <= i + 1 || !canWin(length, total - (i + 1), cur | used, map)) {
                    map.put(used, true);
                    return true;
                }
            }
        }
        map.put(used,false);
        return false;
    }


    /**
     * bool canIWin(int maxChoosableInteger, int desiredTotal) {
     *         if(maxChoosableInteger>=desiredTotal) return true;
     *         if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
     *         unordered_map<int,bool> m;
     *         return canWin(maxChoosableInteger,desiredTotal,0,m);
     *     }
     *     bool canWin(int length,int total,int used,unordered_map<int,bool>& m){
     *         if(m.count(used)) return m[used];
     *         for(int i=0;i<length;i++){
     *             int cur=1<<i;
     *             if((cur&used)==0){
     *                 if(total<=i+1 || !canWin(length,total-(i+1),cur|used,m)){
     *                     m[used]=true;
     *                     return true;
     *                 }
     *             }
     *         }
     *         m[used]=false;
     *         return false;
     *     }
     */
}
