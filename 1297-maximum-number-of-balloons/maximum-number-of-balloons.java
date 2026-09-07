import java.util.*;
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> t = new HashMap<>();
        HashMap<Character, Integer> balloon = new HashMap<>();

        for( int i = 0; i < text.length(); i++){
            char c = text.charAt(i);

            t.put(c , t.getOrDefault(c,0)+1);
        }

        balloon.put('b',1);
        balloon.put('a',1);
        balloon.put('l',2);
        
        balloon.put('o',2);
        
        balloon.put('n',1);


        int res = Integer.MAX_VALUE;
        for(char c : balloon.keySet()){

            if (!t.containsKey(c)) {
                return 0;
            }

            
            int times = t.get(c) / balloon.get(c);
            res = Math.min(res,times);

        }
        return res;
    }
}