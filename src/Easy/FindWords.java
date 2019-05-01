package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWords {
    public String[] findWords(String[] words){
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> resList = new ArrayList<>();

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        // set up the map
        for(char c: row1.toCharArray())
            map.put(c, 1);

        for(char c: row2.toCharArray())
            map.put(c, 2);

        for(char c: row3.toCharArray())
            map.put(c, 3);


        // iterate each word to check all chars are from one row
        for(String word: words)
        {
            char[] wordChars = word.toLowerCase().toCharArray();
            int rowNumber = map.get(wordChars[0]);
            boolean add = true;

            for(char c: wordChars)
            {
                if(rowNumber != map.get(c))
                {
                    add = false;
                    break;
                }

            }

            if(add)
                resList.add(word);
        }

        String[] res = new String[resList.size()];

        for(int i=0; i<res.length; i++)
            res[i] = resList.get(i);

        return res;
    }
}
