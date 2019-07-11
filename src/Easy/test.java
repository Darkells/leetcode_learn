package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import Easy.LargeGroupPositions.*;

public class test{

    public static void main(String[] args){
        System.out.println(100 % 60);

    }


    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

