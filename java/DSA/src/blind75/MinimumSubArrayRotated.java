package blind75;

public class MinimumSubArrayRotated {
    public int findMin(int[] nums) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minValue) minValue = nums[i];
        }
        return minValue;
    }

    public int binarySearch(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low < high) {
            if (nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low) / 2;
            if (nums[low] > nums[mid]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
        }
        if (nums[low] <= nums[high]) return nums[low];
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSubArrayRotated().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
