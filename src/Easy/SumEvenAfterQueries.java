package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dark
 * @2019/6/22 14:03
 */
public class SumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int val = 0;
        int index = 0;
        int[] res = new int[A.length];
        int sum = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        for (int i = 0; i < A.length; i++) {
            val = queries[i][0];
            index = queries[i][1];
            if ((A[index] + val) % 2 == 0) {
                if (A[index] % 2 == 0) {
                    sum += val;
                }else {
                    sum += A[index] + val;
                }
            }else{
                if (A[index] % 2 == 0) {
                    sum -= A[index];
                }
            }
            A[index] += val;
            res[i] = sum;
        }
        return res;
    }

}
