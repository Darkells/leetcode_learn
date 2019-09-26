package Medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dark
 * @2019/9/24 14:29
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return "";
        }

        String[] strings = new String[nums.length];
        for (int i =0; i < strings.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

//        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo((o1 + o2));
            }
        });
        if (strings[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();

    }
}
