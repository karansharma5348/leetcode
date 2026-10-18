class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new  HashMap<>();
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0) + 1);

            // Update maximum frequency
            maxFreq = Math.max(maxFreq,map.get(ch));

            //Current window size
            int windowSize = right - left + 1;

            // Invalid window 
            if(windowSize - maxFreq > k){
                char leftChar = s.charAt(left);

                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            //update answer
            maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
    }
}