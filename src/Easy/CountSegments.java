package Easy;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class CountSegments {
    public static int countSegments(String s){
        if (s == ""){
            return 0;
        }
        int count = 0;
        String[] strings = s.split(" ");
        for (String str : strings){
            if (!"".equals(str)){
                System.out.println(str);
                count++;
            }
        }
        return count;
//        if (s.length() == 0){
//            return null;
//        }
//        String[] strings = s.split(" ");
//        return strings;
    }
}
