package Easy;

/**
 *
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/6/27 22:55
 */
public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        //记录每个人的 信任数 和 被信任数
        int[][] people = new int[N][2];
        for (int[] person : trust) {
            int out = person[0];
            int in = person[1];
            people[out - 1][0]++;
            people[in - 1][1]++;
        }

        //秘密法官的条件  信任数为0，被信任数除了自己  N - 1
       for (int i = 0; i < N; i++) {
            if (people[i][0] == 0 && people[i][1] == N - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
