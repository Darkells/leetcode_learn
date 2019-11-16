package test;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        System.out.println(2 & 1);
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while(n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows < 0 || cols < 0) return 0;
        boolean[][] dp = new boolean[rows][cols];
        int count = CountCore(threshold, rows, cols, 0, 0, dp);
        return count;
    }

    public static int CountCore(int threshold, int rows, int cols, int row, int col, boolean[][] dp) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, dp)) {
            dp[row][col] = true;

            count = 1 + CountCore(threshold, rows, cols, row - 1, col, dp)
                    + CountCore(threshold, rows, cols, row, col - 1, dp)
                    + CountCore(threshold, rows, cols, row + 1, col, dp)
                    + CountCore(threshold, rows, cols, row, col + 1, dp);
        }

        return count;
    }

    public static boolean check (int threshold, int rows, int cols, int row, int col, boolean[][] dp) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && getSum(col) + getSum(row) <= threshold && !dp[row][col]){
            return true;
        }
        return false;
    }

    public static int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

}
