class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> temp = new ArrayList<>();

        boolean insert = false;

        for (int i = 0; i < intervals.length; i++) {

            if (!insert && intervals[i][0] >= newInterval[0]) {
                temp.add(new int[]{newInterval[0], newInterval[1]});
                insert = true;
            }

            temp.add(intervals[i]);
        }

        if (!insert) {
            temp.add(new int[]{newInterval[0], newInterval[1]});
        }

        List<int[]> ans = new ArrayList<>();

        int start1 = temp.get(0)[0];
        int end1 = temp.get(0)[1];

        for (int i = 1; i < temp.size(); i++) {

            int start2 = temp.get(i)[0];
            int end2 = temp.get(i)[1];

            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                ans.add(new int[]{start1, end1});

                start1 = start2;
                end1 = end2;
            }
        }

        ans.add(new int[]{start1, end1});

        return ans.toArray(new int[ans.size()][]);
    }
}