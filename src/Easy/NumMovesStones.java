package Easy;

import java.util.Arrays;

public class NumMovesStones {


    public static int[] numMovesStones(int a, int b, int c) {
        int[] list = {a,b,c};
        int[] res = new int[2];
        Arrays.sort(list);
        int x = list[1] - list[0];
        int y = list[2] - list[1];
        res[1] = list[2] - list[0] - 2;
        if (x == 1 && y == 1){
            res[0] = 0;
        }else if (x <= 2 || y <= 2) {
            res[0] = 1;
        }else {
            res[0] = 2;
        }
        return res;
    }
}
