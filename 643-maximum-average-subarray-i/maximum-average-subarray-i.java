class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowAvg = 0;
        for(int i =0; i < k; i++){
            windowAvg = (windowAvg + nums[i]);
        }

        int maxAvg = windowAvg;

        for(int i = k; i < nums.length; i++){
            windowAvg = (windowAvg + nums[i]) - (nums[i-k]);

            maxAvg = Math.max(maxAvg, windowAvg);
        }
        return (double)maxAvg/k;
    }
}