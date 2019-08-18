package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        //字符串长度，有效的ip地址最段为4，最长为12
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) {
            return res;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    if (i < len && j < len && k < len) {
                        String temp1 = s.substring(0,i + 1);
                        String temp2 = s.substring(i + 1, j + 1);
                        String temp3 = s.substring(j + 1, k + 1);
                        String temp4 = s.substring(k + 1);
                        if (helper(temp1) && helper(temp2) && helper(temp3) && helper(temp4)) {
                            res.add(temp1 + "." + temp2 + "." + temp3 + "." + temp4);
                        }
                    }
                }
            }
        }

        return res;
    }

    private boolean helper(String tmp) {
        if (tmp == null || tmp.length() == 0 || tmp.length() > 3 || (tmp.charAt(0) == '0' && tmp.length() > 1) || Integer.parseInt(tmp) > 255)
            return false;
        return true;
    }


    /**
     *
     * DFS回溯法
     */

    private void backtracking(String s, int pos, List<String> cur, List<String> res) {
        //当cur内容大于等于4就然如最终答案里
        if (cur.size() >= 4) {
            if (pos == s.length()) {
                res.add(String.join(".",cur));
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()) {
                break;
            }
            String temp = s.substring(pos, pos + i);
            if (temp.startsWith("0") && temp.length() > 1 || (i == 3 && Integer.parseInt(temp) > 255)) {
                continue;
            }
            cur.add(temp);
            backtracking(s,pos + i,cur,res);
            cur.remove(cur.size() - 1);
        }
    }
}
