class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;

       

 for (int i = 0; i < k; i++) {
    char c = Character.toLowerCase(s.charAt(i));

    if (c == 'a' || c == 'e' || c == 'i' ||
        c == 'o' || c == 'u') {
        count++;
    }
}
    int maxVowels = count;
    for(int i = k; i< s.length(); i++){
        char outgoing = s.charAt(i-k);
        if (outgoing == 'a' || outgoing == 'e' ||
                outgoing == 'i' || outgoing == 'o' ||
                outgoing == 'u') {
                count--;
            }
    char incoming= s.charAt(i);

            if (incoming == 'a' || incoming == 'e' ||
                incoming == 'i' || incoming == 'o' ||
                incoming == 'u') {
                count++;
            }
            maxVowels = Math.max(count, maxVowels);

            if(maxVowels == k){
                return k;
            }

    }
        return maxVowels;
       
    }
}