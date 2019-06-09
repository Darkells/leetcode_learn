package Easy;

/**
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 *
 * 投影就像影子，将三维形体映射到一个二维平面上。
 *
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回所有三个投影的总面积。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：5
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：
 * 这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 *
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/projection-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @date 2019/6/9 9:43
 */
public class ProjectionArea {
    public int projectionArea(int[][] grid) {
        /**
         * 顶面是看grid的元素数量
         * 正视图是看grid y的最大值 为grid[i][max]
         * 左视图是看grid grid中的最大值
         */
        int len = grid.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            //最大行
            int maxRow = 0;
            //最大列
            int maxCol = 0;
            for (int j = 0; j < len; j++) {
                //顶部阴影面积
                if (grid[i][j] > 0) {
                    res++;
                }
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            res += maxRow + maxCol;
        }
        return res;
    }
}
