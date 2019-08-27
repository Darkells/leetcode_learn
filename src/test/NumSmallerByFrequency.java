package test;

import java.util.ArrayList;
import java.util.List;

public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j< words.length; j++) {
                if (numindex(queries[i]) < numindex(words[j])) {
                    res.add(i);
                }
            }
        }

        return null;
    }

    public int numindex(String s) {
        char[] chars = s.toCharArray();
        char min = 'z';
        int count = 0;
        for (char c : chars) {
            if (c < min) {
                min = c;
            }
        }

        for (char c : chars) {
            if (c == min) {
                count++;
            }
        }
        return count;
    }
}
