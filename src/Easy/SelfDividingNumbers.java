package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dark
 * @date 2019/5/23 9:06
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        while (left <= right){
            int i = left;
            while (i > 0){
                if (i % 10 == 0 || left%(i % 10) == 0){
                    break;
                }
                i /= 10;
                if (i == 0){
                    res.add(left);
                }
                left++;
            }
        }
        return res;
    }
}
