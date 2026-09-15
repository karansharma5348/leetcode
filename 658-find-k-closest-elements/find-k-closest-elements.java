class Solution {
    public int distance(int a , int x){
        return Math.abs(a - x);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue <>(
            (a,b) -> {
                int da = distance(a , x);
                int db = distance(b , x);

                if(da != db){           // larger distance first
                   return db - da;
                }
                 return b - a;           // larger value first

            }
        );

         // Push first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }


        // Push remaining elements
        for (int i = k; i < arr.length; i++) {
            pq.add(arr[i]);

            // Remove the worst element
            pq.poll();
        }

        // Put heap elements into answer
        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        // Heap order is not sorted, so sort answer
        Collections.sort(ans);

        return ans;
    }
}