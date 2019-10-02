package Medium;

/**
 * @author Dark
 * @2019/9/26 14:14
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while(m != n) {
            m >>= 1;
            n >>=1;
            i += 1;
        }

        return m << i;

    }
}
