package Easy;

import java.util.Arrays;

public class test{

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append("2");
        System.out.println(sb.toString());
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

