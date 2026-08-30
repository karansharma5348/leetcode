class Solution {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();

        Map<Character, Integer> hm = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        // Put characters into list
        List<Character> list = new ArrayList<>(hm.keySet());

        // Sort by frequency decreasing
        list.sort((obj1, obj2) -> hm.get(obj2) - hm.get(obj1));

        // Build answer
        for (char ch : list) {
            for (int i = 0; i < hm.get(ch); i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}