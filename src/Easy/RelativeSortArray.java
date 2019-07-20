package Easy;

import java.util.HashMap;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap();
        int index = 0;
        for (int i : arr1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            while (map.get(arr2[i]) != 0) {
                arr1[index++] = arr2[i];
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }

        for (int i = 0; i <= 1000; i++) {
            while (map.containsKey(i) && map.get(i) != 0) {
                arr1[index++] = i;
                map.put(i, map.get(i) - 1);
            }
        }

        return arr1;
    }
}
