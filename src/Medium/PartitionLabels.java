package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            //找到当前字符的最后一次出现的位置
            int lastIndex = S.lastIndexOf(S.charAt(i));
            for (int j = i + 1; j <= lastIndex; j++) {
                //遍历外层截取的子字符串，里面的字符在此字符串外，需要扩展子字符串
                int curIndex = S.lastIndexOf(S.charAt(j));
                if (curIndex > lastIndex) {
                    lastIndex = curIndex;
                }
            }

            list.add(lastIndex - i + 1);
            i = lastIndex;
        }

        return list;
    }
}
