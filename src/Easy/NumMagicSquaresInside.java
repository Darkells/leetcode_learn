package Easy;

/**
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * <p>
 * 而这一个不是：
 * 384
 * 519
 * 762
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 *
 * @author Dark
 * @date 2019/6/6 9:11
 */
public class NumMagicSquaresInside {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid[0].length < 3 || grid.length < 3) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //只用中心为5的矩阵才可能是幻方
                if (grid[i][j] == 5) {
                    boolean fit = true;
                    int[] arr = new int[10];
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            int temp = grid[i + k][j + l];
                            if (temp > 9 || temp < 1 || arr[temp] != 0) {
                                fit = false;
                            } else {
                                arr[temp] = 1;
                            }
                        }
                    }
                    if (fit) {
                        if (
                            //行的值为15
                                grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15 &&
                                        grid[i][j - 1] + grid[i][j] + grid[i][j + 1] == 15 &&
                                        grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15 &&
                                        //列的值为15
                                        grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15 &&
                                        grid[i - 1][j] + grid[i][j] + grid[i + 1][j] == 15 &&
                                        grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == 15 &&
                                        //对角线的值为15
                                        grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1] == 15 &&
                                        grid[i + 1][j - 1] + grid[i][j] + grid[i - 1][j + 1] == 15) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
