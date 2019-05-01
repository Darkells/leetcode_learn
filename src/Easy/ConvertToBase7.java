package Easy;

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 */
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        String s = "";
        //符号标识
        if(num == 0){
            return "0";
        }
        boolean tige = false;
        if(num < 0){
            tige = true;
            num = Math.abs(num);
        }
        StringBuffer sb = new StringBuffer();
        while(num != 0){
            sb.insert(0,num%7);
            num = num / 7;
        }
        if(tige){
            sb.insert(0,"-");
        }
        return sb.toString();
    }
}
