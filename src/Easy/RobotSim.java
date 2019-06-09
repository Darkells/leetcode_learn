package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dark
 * @date 2019/6/9 9:11
 */
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int[][] dire = {{0,1},{1,0},{0,-1},{-1,0}};
        Map<String,Boolean> map = new HashMap<>();
        int k = 0;
        for (int i = 0; i < obstacles.length; i++) {
            map.put(obstacles[i][0] + "," + obstacles[i][1], true);
        }
        int p = 0, q = 0;
        for (int command : commands) {
            //右转
            if (command == -1) {
                k = (k + 1) % 4;
            //左转
            } else if (command == -2) {
                k = (k + 4 - 1) % 4;
            //向上或者向下
            } else {
                int cur[] = dire[k];
                for (int i = 0; i < command; i++) {
                    if (map.containsKey(p + cur[0] + "," + (q + cur[1]))) {
                        break;
                    }
                    p += cur[0];
                    q += cur[1];
                }
                res = Math.max(res,p * p + q * q);
            }
        }
        return res;
    }
}
