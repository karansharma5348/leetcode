class Solution {
    public String reorganizeString(String s) {
         // Frequency map
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max Heap based on frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Put all characters into heap
        for (char ch : map.keySet()) {
            pq.add(ch);
        }

        StringBuilder ans = new StringBuilder();

        char previous = '#';

        while (!pq.isEmpty()) {

            char current = pq.poll();

            // Can't use same character consecutively
            if (current == previous) {

                // No other character available
                if (pq.isEmpty()) {
                    return "";
                }

                char next = pq.poll();
                ans.append(next);
                map.put(next, map.get(next) - 1);  //map se hata diya

                 if (map.get(next) > 0) {    //agar woh map me abhi bhi bacha hua hai to heap me daal do
                    pq.add(next);
                }

                pq.add(current);//jo phela nikla tha use add krlo heap me

                 previous = next;

            }else {

                ans.append(current);
                map.put(current, map.get(current) - 1);

                if (map.get(current) > 0) {
                    pq.add(current);
                }

                previous = current;
            }
        }

        return ans.toString();
    }
}