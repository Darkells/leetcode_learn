package Easy;

/**
 * @author Dark
 * @date 2019/6/8 9:53
 */
public class Transpose {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
