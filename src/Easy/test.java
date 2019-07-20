package Easy;

import java.util.Arrays;

public class test{

    public static void main(String[] args){
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        int[] arr = {1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(duplicateZeros.duplicateZeros(arr)));
    }




    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

