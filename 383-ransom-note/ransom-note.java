class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       HashMap<Character,Integer> ransom = new HashMap<>();
        HashMap<Character,Integer> mag = new HashMap<>();

        for(int i = 0; i < ransomNote.length(); i++){
            char c= ransomNote.charAt(i);
            ransom.put(c,ransom.getOrDefault(c,0)+1);
        }


        for(int i = 0; i < magazine.length(); i++){
            char c= magazine.charAt(i);
            mag.put(c,mag.getOrDefault(c,0)+1);
        }


        for(char c : ransom.keySet()){
            if(!mag.containsKey(c)){
                return false;
            }
            if(mag.get(c) < ransom.get(c)){
                return false;
            }
        }
        return true;

    }
}