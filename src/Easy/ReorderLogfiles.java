package Easy;

import java.util.*;

/**
 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 *
 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
 *
 * 标识符后面的每个字将仅由小写字母组成，或；
 * 标识符后面的每个字将仅由数字组成。
 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
 *
 * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
 *
 * 返回日志的最终顺序。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *  
 *
 * 提示：
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 保证有一个标识符，并且标识符后面有一个字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-log-files
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Dark
 * @2019/6/14 9:23
 */
public class ReorderLogfiles {
    //官方答案
    public String[] reorderLogfiles(String[] logs) {
        Arrays.sort(logs,(log1,log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public String[] reorderLogfiles2(String[] logs) {
        List<String> letterLogs = new LinkedList<>();
        List<String> digitLogs = new LinkedList<>();

        //日志分组
        for (String log : logs) {
            char c = log.charAt(log.indexOf(" ") + 1);
            //是否包含数字
            if (c >= 48 && c <= 57){
                digitLogs.add(log);
            }else {
                letterLogs.add(log);
            }
        }

        //字母日志排序
        letterLogs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String log1 = o1.substring(o1.indexOf(" "));
                String log2 = o2.substring(o2.indexOf(" "));
                return log1.compareTo(log2);
            }
        });

        //聚合日志
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(logs);
    }
}
