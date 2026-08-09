class Solution {

    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        dp = new int[n][n];

        prefix = new int[n + 1];

        // Prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    private int solve(int left, int right) {

        // Only one stone
        if (left == right) {
            return 0;
        }

        // Already calculated
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int ans = 0;

        // Try every possible split
        for (int k = left; k < right; k++) {

            int leftSum = prefix[k + 1] - prefix[left];

            int rightSum = prefix[right + 1] - prefix[k + 1];

            if (leftSum < rightSum) {

                // Must take left
                ans = Math.max(
                    ans,
                    leftSum + solve(left, k)
                );

            } else if (leftSum > rightSum) {

                // Must take right
                ans = Math.max(
                    ans,
                    rightSum + solve(k + 1, right)
                );

            } else {

                // Can take either side
                ans = Math.max(
                    ans,
                    Math.max(
                        leftSum + solve(left, k),
                        rightSum + solve(k + 1, right)
                    )
                );
            }
        }

        dp[left][right] = ans;

        return ans;
    }
}