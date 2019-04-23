package Easy;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 */

/**
 * 解题思路
 * 计算每个1的四周是否有1,4 - 1的个数就是边数
 * <p>
 * 或者遍历 记录1的个数， 总个数 × 4 - 重合边数 × 2
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int li = grid.length;
        int lj = grid[0].length;
        for (int i = 0; i < li; i++) {
            for (int j = 0; j < lj; j++) {
                if (grid[i][j] == 1) {
                    //左边 grid[i][j-1]
                    if (j == 0 || grid[i][j - 1] == 0)
                        result++;
                    //右边 grid[i][j+1]
                    if (j == lj - 1 || grid[i][j + 1] == 0)
                        result++;
                    //上边 grid[i-1][j]
                    if (i == 0 || grid[i - 1][j] == 0)
                        result++;
                    //下边 grid[i+1][j]
                    if (i == li - 1 || grid[i + 1][j] == 0)
                        result++;
                }
            }
        }
        return result;
    }

    //解法2
    public int islanPerimeter2(int[][] grid) {
        int island = 0, cover = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //统计陆地
                if (grid[i][j] == 1) {
                    island++;
                }
                //统计上方的陆地
                if (i - 1 >= 0 && grid[i - 1][j] == 1 && grid[i][j] == 1) {
                    cover++;
                }
                //统计左方的陆地
                if (j - 1 >= 0 && grid[i][j - 1] == 1 && grid[i][j] == 1) {
                    cover++;
                }
            }
        }
        return island * 4 - cover * 2;
    }
}
