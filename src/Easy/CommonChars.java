package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组A，返回列表中的每个字符串中显示的全部字符（包括重复字符）
 * 组成的列表。例如如果一个字符在每个字符串中出现3次，但不是4次，则需要在最终答案中包含该字符
 * 3次。
 * @author Dark
 * @2019/6/29 17:36
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        for (int k = 0; k < 26; k++) {
            char ch = (char) (k + 'a');
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                int count = 0;
                for (int j = 0; j < A[i].length(); j++) {
                    if (A[i].charAt(j) == ch) count++;
                }

                if (count < min) min = count;
            }

            while (min-- > 0) list.add(ch + "");
        }

        return list;
    }
}
