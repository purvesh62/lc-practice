package blind75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = 1;
        System.out.println("Input nums: " + Arrays.toString(nums));
        System.out.println(" ");

        System.out.println("Initial pre:" + Arrays.toString(pre));

        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            System.out.println("Inside loop:" + Arrays.toString(pre));
        }

        int[] post = new int[nums.length];

        post[nums.length - 1] = 1;
        System.out.println(" ");
        System.out.println("Initial post:" + Arrays.toString(post));

        for (int i = nums.length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
            System.out.println("Inside loop:" + Arrays.toString(post));
        }

        for (int i = 0; i < nums.length; i++) {
            pre[i] *= post[i];
        }

        System.out.println("\nOutput: " + Arrays.toString(pre));

        return pre;
    }


    public int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelfOptimized(new int[]{1, 2, 3, 4});
    }
}
