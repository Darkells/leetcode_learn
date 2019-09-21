package Easy;

import Medium.GameOfLife;
import Medium.RestoreIpAddresses;

import java.util.Arrays;

public class test{

    public static void main(String[] args){
        int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife.gameOfLife(board);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

