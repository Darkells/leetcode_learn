package Easy;

/**
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
 *
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 *
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："GGLLGG"
 * 输出：true
 * 解释：
 * 机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
 * 重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
 * 示例 2：
 *
 * 输入："GG"
 * 输出：false
 * 解释：
 * 机器人无限向北移动。
 * 示例 3：
 *
 * 输入："GL"
 * 输出：true
 * 解释：
 * 机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-bounded-in-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        char[] chars = instructions.toCharArray();

        //位置 坐标
        int x = 0;
        int y = 0;

        //方向(0,1)北 (0,-1)南 (1,0)东 (-1,0) 西
        int dx = 0;
        int dy = 1;

        int temp = 0;

        for (char c : chars) {
            switch (c) {
                case 'L' :
                    temp = dx;
                    dx = -dy;
                    dy = temp;
                    break;
                case 'R' :
                    temp = dx;
                    dx = dy;
                    dy = -temp;
                    break;
                default :
                    x += dx;
                    y += dy;
            }
        }

        if ((x == 0 && y == 0) || dx != 0 || dy != 1) {
            return true;
        }

        return false;
    }
}
