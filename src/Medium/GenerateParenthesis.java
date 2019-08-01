package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - 1 - i)) {
                        res.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return res;
    }

    public List<String> generateParenthesis2(int n) {
        List<String>[] totalList = new ArrayList[n + 1];
        for (int i = 0; i < totalList.length; i++) {
            totalList[i] = new ArrayList<>();
        }
        // 0组括号时记为 null
        totalList[0].add(null);
        // 1组括号只有一种情况
        totalList[1].add("()");
        // 开始计算i组括号时的括号组合
        for (int i = 2; i < n + 1; i++) {
            // 存储i组括号对应的组合
            List<String> temp = new ArrayList<String>();
            // 开始遍历 p q ，其中p+q=i-1 , j 作为索引
            for (int j = 0; j < i; j++) {
                //  p = j 时的括号组合情况
                List<String> pList = totalList[j];
                // q = (i-1) - j 时的括号组合情况
                List<String> qList = totalList[i - 1 - j];
                for (String p : pList) {
                    for (String q : qList) {
                        if (p == null)
                            p = "";
                        if (q == null)
                            q = "";
                        // 一组组合
                        String pq = "(" + p + ")" + q;
                        // 把所有可能的情况添加到 temp 中
                        temp.add(pq);
                    }
                }
            }
            totalList[i] = temp;   // temp 这个list就是i组括号的所有情况，添加到total_l中，继续求解i=i+1的情况
        }
        return totalList[n];
    }
}
