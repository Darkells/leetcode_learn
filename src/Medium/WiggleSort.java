package Medium;

import java.util.Arrays;

/**
 *
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        int n = a.length;
        int j = (n + 1) / 2 - 1;
        int k = n - 1;
        int l = j;
        for (int i = 0; i < n;) {
            if (j > -1) {
                nums[i++] = a[j--];
            }
            if (k > l) {
                nums[i++] = a[k--];
            }
        }
    }
}
