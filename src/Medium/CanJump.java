package Medium;

/**
 * @author Dark
 * @2019/8/1 15:00
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        while (start <= end && end < nums.length - 1) {
            end = Math.max(end, nums[start] + start);
            start++;
        }
        return end >= nums.length-1;
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
