class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {

            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            // Find intersection
            int s = Math.max(start1, start2);
            int e = Math.min(end1, end2);

            if (s <= e) {
                ans.add(new int[]{s, e});
            }

            // Move the interval which ends first
            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}