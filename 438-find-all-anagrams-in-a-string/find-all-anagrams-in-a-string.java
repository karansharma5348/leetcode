
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int k = p.length();

        if (k > s.length()) {
            return ans;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count characters in p and the first window of s
        for (int i = 0; i < k; i++) {
            freq1[p.charAt(i) - 'a']++;
            freq2[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            ans.add(0);
        }

        // Slide the window
        for (int right = k; right < s.length(); right++) {
            char incoming = s.charAt(right);
            char outgoing = s.charAt(right - k);

            freq2[incoming - 'a']++;
            freq2[outgoing - 'a']--;

            if (Arrays.equals(freq1, freq2)) {
                ans.add(right - k + 1);
            }
        }

        return ans;
    }
}
