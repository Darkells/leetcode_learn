package Easy;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int res = 0;

        //记录每个小朋友分到的糖果数
        int[] candy = new int[ratings.length];
        candy[0] = 1;

        //从左到右遍历，先比较右边小朋友的分数
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }else {
                candy[i] = 1;
            }
        }

        //从右到左遍历，比较左边小朋友的分数
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1] && candy[j] <= candy[j + 1]) {
                candy[j] = candy[j + 1] + 1;
            }
        }

        for (int k : candy) {
            res += k;
        }
        return res;
    }
}
