package Hard;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalNQueens {
    public boolean is_not_under_attack(int row, int col, int n, int[] rows, int[] hills, int[] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public int backtrack(int row, int count, int n,
                         int[] rows,
                         int[] hills,
                         int[] dales) {
        for (int col = 0; col < n; col++) {
            if (is_not_under_attack(row, col, n, rows, hills, dales)) {
                // place_queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;  // "hill" diagonals
                dales[row + col] = 1;   //"dale" diagonals

                // if n queens are already placed
                if (row + 1 == n) count++;
                    // if not proceed to place the rest
                else count = backtrack(row + 1, count, n,
                        rows, hills, dales);

                // remove queen
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        int rows[] = new int[n];
        // "hill" diagonals
        int hills[] = new int[4 * n - 1];
        // "dale" diagonals
        int dales[] = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }


}
