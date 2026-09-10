class Solution {

    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        
        int index = -1;
        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid] > nums[nums.length-1]){
                low = mid+1;
            }else{
                index = mid;
                high = mid-1;
            }
        }
        // return index;

        int low1=0;
        int high1 = index-1;
        while(low1<=high1){
            int mid1=(low1+high1)/2;
             if(nums[mid1]==target){
                return mid1;
            }
            else if(target>nums[mid1]){
                low1=mid1+1;
            }
            else{
                high1=mid1-1;
            }
        }

        int low2=index;
        int high2 = nums.length-1;
        while(low2<=high2){
            int mid2=(low2+high2)/2;
             if(nums[mid2]==target){
                return mid2;
            }
            else if(target>nums[mid2]){
                low2=mid2+1;
            }
            else{
                high2=mid2-1;
            }
        }
        return -1;
        
    }
}