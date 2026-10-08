import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        long ans = 0;
        int mod = 1000000007;

        long[] power = new long[nums.length];
        power[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        while (left <= right) {

            if (nums[left] + nums[right] <= target) {

                ans = (ans + power[right - left]) % mod;
                left++;

            } else {
                right--;
            }
        }

        return (int) ans;
    }
}