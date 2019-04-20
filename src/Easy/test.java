package Easy;

import java.util.List;

public class test {
    public static void main(String[] args){
        List<Integer> list = FindAnagrams.findAngrams("cbaebabacd","abc");
        for (int i : list){
            System.out.println(i);
        }
    }
}
