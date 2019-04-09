package Easy;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums){
        int max = 0;
        int count = 0;
        for(int i :nums){
            if (i == 1){
                count++;
            }else{
                if(count > max){
                    max = count;
                }
                count = 0;
            }
        }
        return max > count ? max : count;
    }
}
