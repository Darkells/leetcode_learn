package Medium;

/**
 * @author Dark
 * @2019/11/3 16:02
 */
public class LastRemaining {
    public static int lastRemaining(int n) {
        if (n < 3) {
            return n;
        }

        //如果n为偶数
        if (n % 2 == 0) {
            return 2 * (n/2 + 1 - lastRemaining(n / 2));
        } else {
            return lastRemaining(n - 1);
        }
    }
}
