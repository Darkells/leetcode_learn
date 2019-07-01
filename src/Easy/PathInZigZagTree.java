package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dark
 * @2019/6/30 10:53
 */
public class PathInZigZagTree {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> pathInZigZagTree(int label) {


    }

    public void path(int label) {
        if (label == 1) {
            list.add(1);
        }
        int i = 1;
        int index = 0;
        for (int j = 1; j < label;j = j + j*2) {
            i++;
        }
        index = (int) Math.pow(2,i-1) + 1;
        int temp = (label - index) / 2;
        path(temp);
    }
}
