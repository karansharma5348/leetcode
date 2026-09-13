import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // 1. Count frequency
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 2. Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if(map.get(a).equals(map.get(b))) {
                    return b.compareTo(a);
                }

                return map.get(a) - map.get(b);
            }
        );

        // 3. Keep only k words
        for(String word : map.keySet()) {

            pq.add(word);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        // 4. Create answer
        List<String> ans = new ArrayList<>();

        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        // Heap gives reverse order, so reverse it
        Collections.reverse(ans);

        return ans;
    }
}