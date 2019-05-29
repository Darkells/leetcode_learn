package Easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dark
 * @date 2019/5/29 9:09
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new LinkedList<>();
        dfs("", s, res, 0);
        return res;
    }

    public void dfs(String pre, String s, List<String> res, int index) {
        if (index == s.length()) {
            res.add(pre);
        } else {
            char ch = s.charAt(index);
            if (!Character.isLetter(ch)) {
                dfs(pre + ch, s, res, index + 1);
            } else {
                ch = Character.toLowerCase(ch);
                dfs(pre + ch, s, res, index + 1);

                ch = Character.toUpperCase(ch);
                dfs(pre + ch, s, res, index + 1);
            }
        }
    }
}
