class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zero = 0;
        int maxLen = 0;

        for(int right = 0; right < nums.length; right++) {

            // Add current element to window
            if(nums[right] == 0) {
                zero++;
            }

            // If more than k zeros, shrink window
            while(zero > k) {

                if(nums[left] == 0) {
                    zero--;
                }

                left++;
            }

            // Calculate current valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}