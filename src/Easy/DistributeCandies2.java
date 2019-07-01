package Easy;

/**
 * @author Dark
 * @2019/6/30 10:31
 */
public class DistributeCandies2 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int candie = 1;
        int index = 0;
        while(candies > 0) {
            if (index > num_people) {
                index = 0;
            }
            if (candie > candies) {
                res[index] = candies;
            }else {
                res[index] = candie;
            }
            candies -= candie;
            candie++;
            index++;
        }
        return res;
    }
}
