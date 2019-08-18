package Medium;

/**
 * @author Dark
 * @2019/8/9 13:53
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        //定义边界  左、右、上、下；
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] res = new int[n][n];


        int num = 1, target = n * n;
        while (num <= target) {
            //从左到右
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;

            //从上到下
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;

            //从右到左
            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
            }
            b--;

            //从下到上
            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
        }

        return res;
    }
}
