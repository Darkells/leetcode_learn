package Easy;

import java.util.Arrays;

/**
 * @author Dark
 * @2019/6/16 8:26
 */
public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        for (int i = 3; i >= 0; i--) {
            if (A[i] > 2) continue;
            for (int j = 3; j >= 0; j--) {
                if (j == i || A[i] == 2 && A[j] < 3) continue;
                for (int k = 3; k >=0; k--) {
                    if (k == i || k == j || A[k] > 5) continue;
                    return "" + A[i] + A[j] + ':' + A[k] + A[6 - i - j -k];
                }
            }
        }
        return "";
    }
}
