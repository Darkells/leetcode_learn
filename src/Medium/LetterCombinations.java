package Medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dark
 * @2019/7/27 16:27
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) {
            return res;
        }
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char c : mapping[x].toCharArray()) {
                    res.add(t + c);
                }
            }
        }

        return res;
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.isEmpty())
            return res;
        res.add("");

        while (res.peek().length() != digits.length()) {
            String temp = res.pop();
            String value = map[digits.charAt(temp.length()) - '0'];
            for (char c : value.toCharArray())
                res.add(temp + c);
        }
        return res;
    }
}
