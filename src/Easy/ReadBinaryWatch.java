package Easy;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 60; j++){
                if (count(i) + count(j) == num){
                    res.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return res;
    }

    public int count(int i){
        int res = 0;
        while (i != 0){
            i = i &(i - 1);
            res++;
        }
        return res;
    }
}
