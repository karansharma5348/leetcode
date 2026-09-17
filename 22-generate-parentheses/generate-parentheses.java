class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        fun(0, 0, n, "", ans);

        return ans;
    }

    public void fun(int open, int close, int n,
                    String temp, List<String> ans) {

        if (open == n && close == n) {
            ans.add(temp);
            return;
        }

        if (open < n) {
            fun(open + 1, close, n, temp + "(", ans);
        }

        if (close < open) {
            fun(open, close + 1, n, temp + ")", ans);
        }
    }
}