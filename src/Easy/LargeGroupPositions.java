package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dark
 * @date 2019/6/5 9:21
 */

/**
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 *
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 *
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 *
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 */
public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        char[] temp = S.toCharArray();
        //双指针法,start起始位置，end结束位置
        int start = 0, end = 0;
        while (end < temp.length - 1){
            //查找相同的字符
            while (temp[end] == temp[end + 1]){
                end++;
            }

            //判断是否为较大分组
            if (end - start + 1 >= 3){
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                res.add(list);
            }

            //换新的分组检测
            end++;
            start = end;
        }
        return res;
    }

    public List<List<Integer>> largeGroupPositions2(String s){
        List<List<Integer>> res = new ArrayList<>();
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");
        Matcher matcher = pattern.matcher(s);
        int start = 0;
        int len = 0;
        while (matcher.find()) {
            String temp = matcher.group();
            len = temp.length();
            if (len >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(start + len - 1);
                res.add(list);
            }
            start = start + len;
        }
        return res;
    }
}
