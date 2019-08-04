package Medium;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1,-1};
        }
        int num1 = findLowerBound(nums, target);
        // 细节：如果左边界都搜索不到，右边界也没有必要看了
        if (num1 == -1) {
            return new int[]{-1, -1};
        }
        int num2 = findUpBound(nums, target);
        return new int[]{num1, num2};
    }

    private int findLowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findUpBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }
}
