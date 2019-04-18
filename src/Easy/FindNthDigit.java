package Easy;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * <p>
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * <p>
 * 输出:
 * 3
 * 示例 2:
 * <p>
 * 输入:
 * 11
 * <p>
 * 输出:
 * 0
 * <p>
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int index = 1;
        long t = 9l;
        while (n > t * index) {
            n = (int) (n - t * index);
            t = t * 10;
            index++;
        }

        int findint = (int) Math.pow(10, index - 1);
        int nofindint = (n - 1) / index;
        findint += nofindint;
        char c = String.valueOf(findint).toCharArray()[(n - 1) % index];

        return Integer.parseInt("" + c);
    }
}
