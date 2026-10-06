class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int largest = nums.length-1 ; largest >= 2 ; largest--){
            int left =0;
            int right = largest-1;

            while(left < right){
                if(nums[left] + nums[right] > nums[largest]){
                    count+= right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return count;

    }
}