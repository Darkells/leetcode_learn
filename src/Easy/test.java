package Easy;

import java.util.Arrays;

public class test{

    public static void main(String[] args){
        System.out.println(10 ^ 3);
    }




    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

