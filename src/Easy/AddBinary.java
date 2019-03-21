package Easy;

/**
 * @author Dark
 * @date 2019/3/21 22:12
 */

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class AddBinary {
    /**
     * 第一种想法，转为十进制，计算。结果转二进制返回
     * 第二种想法，对齐，对位。处理 1 1的情况考虑进位
     */
    public static String addBinary01(String a, String b) {
        int ia = Integer.parseInt(a, 2);
        int ib = Integer.parseInt(b, 2);
        System.out.println(ia + " " + ib);
        String c = Integer.toBinaryString((ia + ib));
        return c;
    }


    public static String addBinary02(String a,String b){
        int lengthA = a.length() - 1;
        int lengthB = b.length() - 1;
        //设置一个进位标记
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (lengthA >= 0 || lengthB >= 0){
            int x = (lengthA >= 0)?a.charAt(lengthA) - '0':0;
            int y = (lengthB >= 0)?b.charAt(lengthB) - '0':0;
            int sum = x + y + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            lengthA--;
            lengthB--;
        }
        if (carry > 0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String c = addBinary02("1", "11");
        System.out.println(c);
    }
}
