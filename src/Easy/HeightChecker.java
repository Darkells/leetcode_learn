package Easy;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] hashmap = new int[101];
        int count = 0;
        for (int height : heights) {
            hashmap[height]++;
        }
        for (int i = 1, j = 0; i < hashmap.length; i++) {
            while (hashmap[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }

        return count;
    }
}
