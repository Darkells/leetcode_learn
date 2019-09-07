package Easy;

import Medium.RestoreIpAddresses;

import java.util.Arrays;

public class test{

    public static void main(String[] args){
//        for (String s : RestoreIpAddresses.restoreIpAddresses("25525511135")){
//            System.out.println(s);
//        }
        System.out.println((Integer.highestOneBit(14) * 2 - 1) >> 1);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

