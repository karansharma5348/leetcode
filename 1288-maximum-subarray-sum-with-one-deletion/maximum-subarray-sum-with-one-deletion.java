class Solution {
    public int maximumSum(int[] arr) {
        int nodelete = arr[0];
        int onedelete = Integer.MIN_VALUE;
        int ans = arr[0];

        for(int i = 1; i < arr.length; i++){
            int prevnodelete = nodelete;
            int prevonedelete = onedelete;

            nodelete = Math.max(nodelete + arr[i], arr[i]);

            int v2;

            if(prevonedelete == Integer.MIN_VALUE){
                v2 = arr[i];
            }else{
                v2 = prevonedelete + arr[i];
            }
            onedelete = Math.max(v2 , prevnodelete);
            ans = Math.max(ans,Math.max(nodelete,onedelete));
        }
        return ans;
    }
}