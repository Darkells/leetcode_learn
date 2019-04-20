package Easy;

public class Compress {
    public int compress(char[] chars){
        int index = 0; //用来更新chars
        int i = 0; //用来遍历chars
        while (i < chars.length) {
            int sum = 1;
            for (int j = i + 1; j < chars.length; j++) { //找到有几个相等的字符
                if (chars[j] != chars[i]) {
                    break;
                }
                sum++;
            }
            chars[index++] = chars[i];
            if (sum > 1) {
                String s = String.valueOf(sum);
                for (int k = 0; k < s.length(); k++) {
                    chars[index++] = s.charAt(k);
                }
            }
            i += sum;
        }
        return index;
    }
}
