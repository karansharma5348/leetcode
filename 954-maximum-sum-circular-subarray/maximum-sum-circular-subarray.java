class Solution {
    //maximum subnumsaySum
     public int maxSubarray(int[] nums) {
        int bestEnding = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            int v1 = bestEnding + nums[i];
            int v2 = nums[i];
            bestEnding = Math.max(v1 , v2);
            ans= Math.max(ans , bestEnding);
        }
        return ans;
     }


        //Minimum SubnumsaySum
        public int minSubarraySum(int[] nums) {
        // code here
        
        int bestEnding = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            int v1 = bestEnding + nums[i];
            int v2 = nums[i];
            bestEnding = Math.min(v1 , v2);
            ans= Math.min(ans , bestEnding);
        }
        return ans;
        }

        // Array Sum

        public int arraySum(int[] nums){
            int sum =0;
            for(int i =0 ; i < nums.length ;i++){
                sum= sum + nums[i];
            }
            return sum;
        }

    public int maxSubarraySumCircular(int[] nums) {

        int normal = maxSubarray(nums);

    // All numbers are negative
        if (normal < 0) {
            return normal;
         }
        
        int circular = arraySum(nums) - minSubarraySum(nums);
        return Math.max(maxSubarray(nums), circular);
    }

}