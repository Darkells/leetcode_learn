package Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {
    //想用DFS算法
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowlen = grid.length;
        int collen = grid[0].length;
        int res = 0;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    //深度优先递归
    public void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }


    public class Pos{
        int i;
        int j;
        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowlen = grid.length;
        int collen = grid[0].length;
        int res = 0;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    Queue<Pos> queue = new LinkedList<>();
                    queue.add(new Pos(i, j));
                    while(!queue.isEmpty()) {
                        Pos current = queue.poll();
                        // 上
                        if (current.i - 1 >= 0 && grid[current.i - 1][current.j] == '1') {
                            queue.add(new Pos(current.i - 1, current.j));
                            grid[current.i - 1][current.j] = '0';
                            // 没有continue.
                        }
                        // 下
                        if (current.i + 1 <= grid.length - 1 && grid[current.i + 1][current.j] == '1') {
                            queue.add(new Pos(current.i + 1, current.j));
                            grid[current.i + 1][current.j] = '0';
                        }
                        // 左
                        if (current.j - 1 >= 0 && grid[current.i][current.j - 1] == '1') {
                            queue.add(new Pos(current.i, current.j - 1));
                            grid[current.i][current.j - 1] = '0';
                        }
                        // 右
                        if (current.j + 1 <= grid[0].length - 1 && grid[current.i][current.j + 1] == '1') {
                            queue.add(new Pos(current.i, current.j + 1));
                            grid[current.i][current.j + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}
