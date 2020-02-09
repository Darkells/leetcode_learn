package Medium;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 *
 * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
 *
 * 示例 1:
 *
 * 输入: "172.16.254.1"
 *
 * 输出: "IPv4"
 *
 * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
 * 示例 2:
 *
 * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * 输出: "IPv6"
 *
 * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 * 示例 3:
 *
 * 输入: "256.256.256.256"
 *
 * 输出: "Neither"
 *
 * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidIPAddress {
    /**
     * 正则表达式匹配法
     * @param IP    匹配IP
     * @return  匹配结果
     */
    public String validIPAddress(String IP) {
        if(IP.matches("((2[0-5][0-5]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(2[0-5][0-5]|1[0-9][0-9]|[1-9][0-9]|[0-9])")) return "IPv4";
        else if(IP.matches("(([0-9]|[a-f]|[A-F]){1,4}:){7}(([0-9]|[a-f]|[A-F]){1,4})")) return "IPv6";
        else return "Neither";
    }

    public String validIPAddress2(String IP) {
        if (IP.length() == 0 || IP.length() < 7 || IP.length() > 39) {
            return "Neither";
        }
        //IPv4地址匹配
        if (IP.contains(".")) {
            if(IP.charAt(IP.length() - 1) == '.') return "Neither";
            String[] str = IP.split("\\.");
            if (str.length != 4) {
                return "Neither";
            }
            for (int i = 0; i < str.length; i++) {
                if (str[i].length() == 0) return "Neither";
                for (int j = 0; j < str[i].length(); j++) {
                    if (!((str[i].charAt(j) >= '0' && str[i].charAt(j) <= '9'))) return "Neither";
                    if (str[i].charAt(j) == '0' && j == 0 && str[i].length() > 1) return "Neither";
                }
                int check = Integer.parseInt(str[i]);
                if (check > 255) return "Neither";
            }
            return "IPv4";
        } else {
            if(IP.charAt(IP.length() - 1) == ':') return "Neither";
            String[] six = IP.split("\\:");
            if (six.length != 8) {
                return "Neither";
            }
            for(int i = 0;i < six.length;i++) {
                if(six[i].length() > 4 || six[i].length() == 0) return "Neither";
                for(int j = 0;j < six[i].length();j++) {
                    if(!((six[i].charAt(j) >= '0' && six[i].charAt(j) <= '9') || (six[i].charAt(j) >= 'a' && six[i].charAt(j) <= 'f') || (six[i].charAt(j) >= 'A' && six[i].charAt(j) <= 'F'))) return "Neither";
                }
            }
            return "IPv6";
        }
    }
}
