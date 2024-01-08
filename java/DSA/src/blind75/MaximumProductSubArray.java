package blind75;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prev = 1;
        int post = 1;


        for (int i = 0; i < nums.length; i++) {
            if (prev == 0) prev = 1;
            if (post == 0) post = 1;

            prev *= nums[i];
            post *= nums[nums.length - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prev, post));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubArray().maxProduct(new int[]{-1, -2, -3, -4, -5}));
    }
}
