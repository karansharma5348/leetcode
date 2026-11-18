class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> ans = new ArrayList<>();
        if(points.length == 0) return 0;
        int start1 =points[0][0];
        int end1 = points[0][1];

        for(int i = 1; i < points.length; i++){
            int start2 = points[i][0];
            int end2 = points[i][1];

            if(end1 >= start2){
                start1 = start1;
                end1= Math.min(end1, end2);
                continue;
            }
            ans.add(new int []{ start1, end1});
            start1 = start2;
            end1= end2;
        }
        ans.add(new int[]{start1,end1});
         return ans.size();
    }
}
    
