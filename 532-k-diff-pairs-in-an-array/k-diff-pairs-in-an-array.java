import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;
        while( right < nums.length){
            if(nums[right] - nums[left] == k){
                count++;
                
            
            int leftValue = nums[left];
            int rightValue = nums[right];
            
            while(left < nums.length && leftValue == nums[left]){
                left++;
            }
            while(right < nums.length && rightValue == nums[right]){
                right++;
            }
            }
            
         else if(nums[right] - nums[left] > k ){
            left++;
        }else{
            right++;
        }
        if (left == right) {
                right++;
            }
        }
        return count;
    }
}