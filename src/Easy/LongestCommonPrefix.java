package Easy;

/**
 * @author Dark
 * @date 2019/3/7 22:42
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        //想起python有个append的函数，java里类似的就是使用StringBuilder里
        StringBuilder sb =new StringBuilder();
        if (strs.length>1) {
            //设第一个为榜样，做对比
            int len = strs[0].length();
            for (int i = 0; i < len; i++) {
                char curr = strs[0].charAt(i);
                //遍历剩余的字符串并进行对比
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length()<=i ||strs[j].charAt(i) != curr) {
                        return "";
                    }
                    if (strs[j].charAt(i) == curr && j == strs.length - 1) {
                        return sb.append(curr).toString();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 评论区大佬的算法  暴力破解
     * @param args
     */
        public String longestCommonPrefix2(String[] strs) {
            if (strs == null || strs.length == 0)
                return "";
            //以第一个字符串为榜样
            String common = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(common) != 0) {
                    common = common.substring(0, common.length() - 1);
                    if (common == "")
                        return "";
                }
            }
            return common;
        }

    public static void main(String[] args){
        String[] strings = {"aa","aaa","a"};
        System.out.println(longestCommonPrefix(strings));
    }
}
