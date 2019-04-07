package Easy;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IsHappy {
    public boolean isHappy(int n) {
        int res = 0;
        while (true){
            res += (n%10)*(n%10);
            n /= 10;
            if (n == 0){
                if (res == 1){
                    return true;
                }else if (res == 4 || res == 16 || res == 37 || res == 58 || res == 89 || res == 145 || res == 42 || res == 20){
                    return false;
                }else {
                    n = res;
                    res = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(21 / 10 + " " + 21 % 10);
    }
}
