package Medium;

public class MatrixScore {
    /**
     * 1.先横竖交换保证第一列全部为1
     * 2.竖变换保证其他列1比0多
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int i = 0, j = 0;
        int count = 0, res = 0;
        for (i = 0; i < A.length; i++) {
            if (A[i][0] != 1) {
                for (j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
            }
        }

        res = A.length * sum(A[0].length - 1);
        for( j = 1; j <A[0].length ; j++ ){
            count = 0;
            for(i = 0; i < A.length ; i++){
                if(A[i][j] == 1) count++;
            }
            //如果0的个数比1多，翻转
            if(count <= A.length/2){
                count = A.length - count;
            }
            res += count * sum(A[0].length-1-j);
        }
        return res;
    }

    private int sum(int a) {
        int result = 1;
        for (int i = 0; i < a; i++) {
            result = result << 1;
        }
        return result;
    }
}
