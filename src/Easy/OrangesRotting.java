package Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/6/26 14:27
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        //表示四个方向
        int dire[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        Queue<int []> duillie = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[j].length; j++) {
                if (grid[i][j] == 2) {
                    duillie.offer(new int[]{i,j});
                }
            }
        }

        int result = 0;
        while (!duillie.isEmpty()) {
            int size = duillie.size();
            //进行感染
            for (int i = 0; i < size; i++) {
                int[] point = duillie.poll();
                for (int p[] : dire) {
                    int x = point[0] + p[0];
                    int y = point[1] + p[1];
                    if (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)) {
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            duillie.offer(new int[] {x,y});
                        }
                    }
                }
            }
            result++;
        }

        for (int[] is : grid) {
            for (int i : is) {
                if(i == 1){
                    return -1;
                }
            }
        }

        return result == 0? 0: result - 1;
    }
}
