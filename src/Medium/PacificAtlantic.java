package Medium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    private boolean[][] pacific;
    private boolean[][] atlantic;
    private int row, col;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        row = matrix.length;
        col = matrix[0].length;

        pacific = new boolean[row][col];
        atlantic = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, col - 1);
        }

        for (int i = 0; i < col; i++) {
            dfs(matrix, pacific, 0, i);
            dfs(matrix, atlantic, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] map, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || map[i][j])
            return;
        map[i][j] = true;
        if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j])
            dfs(matrix, map, i - 1, j);
        if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1])
            dfs(matrix, map, i, j - 1);
        if (i + 1 < row && matrix[i][j] <= matrix[i + 1][j])
            dfs(matrix, map, i + 1, j);
        if (j + 1 < col && matrix[i][j] <= matrix[i][j + 1])
            dfs(matrix, map, i, j + 1);
    }
}
