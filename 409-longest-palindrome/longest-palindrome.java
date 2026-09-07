import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        boolean odd = false;

        // Check even and odd frequencies
        for (char c : map.keySet()) {

            int freq = map.get(c);

            if (freq % 2 == 0) {
                // Even frequency -> use everything
                ans += freq;
            } else {
                // Odd frequency -> use freq - 1
                ans += freq - 1;
                odd = true;
            }
        }

        // One odd character can be placed in the center
        if (odd) {
            ans++;
        }

        return ans;
    }
}