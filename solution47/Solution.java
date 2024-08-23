package solution.solution47;

/*
    矩阵走格子 到末尾时最大值
 */

class Solution {
    // dp
    public int jewelleryValue(int[][] frame) {
        int[] dp = new int[frame[0].length];
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame[i].length; j++) {
                if (dp[i] == 0 && dp[j] == 0) {
                    dp[j] = 1;
                } else if (i == 0) {
                    dp[j] = dp[j-1]+frame[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j]+frame[i][j];
                } else {
                    dp[j] = max(dp[j],dp[j-1])+frame[i][j];
                }
            }
        }
        return dp[frame[0].length-1];
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
