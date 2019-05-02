package Easy;

public class ReverseStr2 {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int length = sArr.length;

        for (int i = 0; i <= length / k + 1; i++) {
            int left = 2 * i * k;
            int right = left + k - 1;
            if (right >= length) {
                right = length - 1;
            }
            while (left < right) {
                char temp = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(sArr);
    }
}
