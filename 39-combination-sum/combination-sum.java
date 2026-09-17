import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        fun(candidates, 0, new ArrayList<>(), 0, res, target);

        return res;
    }

    public void fun(int[] candidates, int idx,
                    List<Integer> diary,
                    int sum,
                    List<List<Integer>> res,
                    int target) {

        // Base case
        if (sum == target) {
            res.add(new ArrayList<>(diary));
            return;
        }

        if (idx == candidates.length) {
            return;
        }

        // Choice 1: Don't take
        fun(candidates, idx + 1, diary, sum, res, target);

        // Choice 2: Take
        if (sum + candidates[idx] <= target) {

            diary.add(candidates[idx]);
            sum = sum + candidates[idx];

            // Same idx because we can take it again
            fun(candidates, idx, diary, sum, res, target);

            // Backtrack
            diary.remove(diary.size() - 1);
            sum = sum - candidates[idx];
        }
    }
}