package test;

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
}
