package Easy;

/**
 * @author Dark
 * @date 2019/5/29 9:38
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 2; i <= N; i++){
            String s = String.valueOf(i);
            if ( s.contains("3") || s.contains("4") || s.contains("7")){
                    continue;
            }
            if (s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")){
                count++;
            }
        }
        return count;
    }
}
