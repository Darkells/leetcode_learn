package Medium;

import java.util.Arrays;

/**
 * @author Dark
 * @2019/8/5 14:08
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        int res = 0;
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                res += (num2.charAt(j) - '0') * (int)Math.pow(10,num2.length() - 1 - j) * (num1.charAt(i) - '0') * (int)Math.pow(10,num1.length() - 1 - i);
            }
        }
        return res + "";
    }

    public String multiply2(String num1, String num2) {
        char[] ret = new char[num1.length() + num2.length()];
        Arrays.fill(ret, '0');

        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1val = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num2val = num2.charAt(j) - '0';
                int sum = (ret[i+j+1] - '0') + num1val * num2val;
                ret[i + j + 1] = (char)(sum % 10 + '0');
                ret[i + j] += sum / 10;
            }
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < num1.length() + num2.length() - 2; i++) {
//            if (ret[i] != '0' || i == ret.length - 1) {
//                return new String(ret, i, ret.length - i);
//            }
            str.append(ret[i]);
        }

        return str.toString();

    }
}
