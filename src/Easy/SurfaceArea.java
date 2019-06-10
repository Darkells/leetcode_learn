package Easy;

/**
 * @author Dark
 * @date 2019/6/10 9:09
 */
public class SurfaceArea {
    //城市包围农村的情况出错
    public int surfaceArea(int[][] grid) {
        int len = grid.length, res = 0;
        for (int i = 0; i < len; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < len; j++) {
                if (grid[i][j] > 0) {
                    res++;
                }
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            res += maxCol + maxRow;
        }
        return res * 2;
    }

    /**
     * 三维体的表面积 = 每个位置上组合立方体的表面积 - 每个位置上组合立方体的邻接面积
     */

    public int surfaceArea2(int[][] grid) {
        int len = grid.length;
        //每个位置上的表面积，每个位置的邻接面积
        int area1 = 0, area2 = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                //该位置存在立方体
                if (grid[i][j] != 0) {
                    area1 += grid[i][j] * 4 + 2;
                }
                if (i != len - 1) {
                    area2 += (grid[i][j] > grid[i + 1][j] ? grid[i + 1][j] : grid[i][j]) * 2;
                    area2 += (grid[j][i] > grid[j][i + 1] ? grid[j][i + 1] : grid[j][i]) * 2;
                }
            }
        }
        return area1 - area2;
    }
}
