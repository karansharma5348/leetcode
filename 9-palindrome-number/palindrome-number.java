class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int revNum = 0;
        if( x < 0 ){
            return false;
        }
        while( x != 0){
            int lastNum = x % 10;
            x = x / 10;
            revNum=(revNum * 10) + lastNum;
             
        }
        if (revNum == temp){
            return true;

        }
        return false;
    }
}