class Solution {
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;
        for(int i =0; i < t.length();i++){

            if(left < s.length() && s.charAt(left) == t.charAt(right)){
                left++;
                
            }
                right++;
            
        }
        return left == s.length();
    }
}