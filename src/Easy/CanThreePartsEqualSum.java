package Easy;

/**
 * @author Dark
 * @2019/7/11 16:54
 */
public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int i = 0;//第一部分的最后下标
        int j = A.length - 1;//第三部分的开始下标
        int left = 0;
        int right = 0;
        int target = sum / 3;
        for (int k = 0; k < A.length; k++) {
            if (left != target) {
                left += A[i++];
            }
            if (right != target) {
                right += A[j--];
            }
            if (i > j) {
                return false;
            }
        }
        return true;
    }
}
