class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[mid+1]){
                res= mid;
                high= mid-1;
            }else {
                low = mid+1;
        }
        }
        return res;
        
    }
}