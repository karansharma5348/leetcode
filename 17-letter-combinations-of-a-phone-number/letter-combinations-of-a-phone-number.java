class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

      

        String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };
        
          fun(0,digits,"",ans,map);
        return ans;


    }
    public void fun(int index, String digits, String temp, List<String>ans, String[]map){
         // Base case
        if(index == digits.length()){
            ans.add(temp);
            return;
        }
        // Get letters for current digit
        String letters = map[digits.charAt(index) - '0'];
        //Try every character
        for(int i = 0; i< letters.length();i++){
            fun(index+1,digits,temp+letters.charAt(i),ans,map);
        }
    }
}