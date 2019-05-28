package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import Easy.ShortestCompletingWord.*;

public class test {
    public static void main(String[] args){
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        String[] strings = {"step","steps","stripe","stepple"};
        System.out.println(shortestCompletingWord.shortestCompletingWord2("1s3 PSt",strings));
    }
}
