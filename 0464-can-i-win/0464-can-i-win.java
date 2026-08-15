class Solution {

    int max;
    int[] memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= 0) {
            return true;
        }

        int total = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        if (total < desiredTotal) {
            return false;
        }

        max = maxChoosableInteger;

        memo = new int[1 << max];

        return dfs(0, desiredTotal);
    }

    private boolean dfs(int mask, int remaining) {

        if (memo[mask] != 0) {
            return memo[mask] == 1;
        }

        for (int i = 1; i <= max; i++) {

            int bit = 1 << (i - 1);

            if ((mask & bit) == 0) {

                if (i >= remaining) {
                    memo[mask] = 1;
                    return true;
                }

                boolean opponentWins =
                    dfs(mask | bit, remaining - i);

                if (!opponentWins) {
                    memo[mask] = 1;
                    return true;
                }
            }
        }

        memo[mask] = 2;
        return false;
    }
}