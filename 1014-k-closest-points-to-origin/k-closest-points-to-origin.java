import java.util.*;

class Solution {

    public int distance(int[] point) {
        int x = point[0];
        int y = point[1];

        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int k) {

        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a)
        );

        // Push first k elements
        for (int i = 0; i < k; i++) {
            pq.add(points[i]);
        }

        // Push remaining elements and remove farthest
        for (int i = k; i < points.length; i++) {

            pq.add(points[i]);

            pq.poll();
        }

        // Create answer
        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}