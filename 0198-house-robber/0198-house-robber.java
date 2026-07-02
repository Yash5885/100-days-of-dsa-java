class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int pick = num + prev2;
            int notPick = prev1;

            int current = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}