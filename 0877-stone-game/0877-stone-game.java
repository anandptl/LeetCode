// class Solution {
//     public boolean stoneGame(int[] piles) {
//         return true;
//     }
// }

class Solution {

    public boolean stoneGame(int[] piles) {

        int n = piles.length;

        int[][] dp = new int[n][n];

        // Base case:
        // Only one pile available
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Length of subarray
        for (int len = 2; len <= n; len++) {

            for (int left = 0; left + len <= n; left++) {

                int right = left + len - 1;

                int takeLeft =
                        piles[left] - dp[left + 1][right];

                int takeRight =
                        piles[right] - dp[left][right - 1];

                dp[left][right] =
                        Math.max(takeLeft, takeRight);
            }
        }

        return dp[0][n - 1] > 0;
    }
}