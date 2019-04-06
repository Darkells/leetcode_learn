package Easy;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 */
public class TitleToNumber {
    public static int titleToNunber(String s){
        int ans = 0, len = s.length();
        char[] c = s.toCharArray();
        for(int i = 0; i < len; i++){
            ans = ans * 26 + (c[i]-'A'+1);
        }
        return ans;
    }

    public static void main(String[] args){
        int i = titleToNunber("ZY");
        System.out.println(i);
    }
}
