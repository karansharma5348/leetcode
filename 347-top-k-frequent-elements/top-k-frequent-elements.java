import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // 3. Keep only k elements
        for(int num : map.keySet()) {

            pq.add(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        // 4. Store answer
        int[] ans = new int[k];

        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}