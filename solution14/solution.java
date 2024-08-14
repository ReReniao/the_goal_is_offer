package solution.solution14;

class solution {
    public int cuttingBamboo(int bamboo_len) {
        int[] dp = new int[bamboo_len + 1];
        dp[2] = 1;
        for (int i = 3; i <= bamboo_len; i++) {
            for (int j = 1; j <= i/2; j++) {
                // 从1开始拆分
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i - j]));
            }
        }
        return dp[bamboo_len];
    }
}

class solution1 {
    public int cuttingBamboo(int bamboo_len) {
        final long MOD = 1000000007;
        if (bamboo_len <= 3) {
            return bamboo_len-1;
        }
        if (bamboo_len == 4) {
            return 4;
        }
        long res = 1;
        while (bamboo_len > 4) {
            bamboo_len -= 3;
            res = res * 3 % MOD;
        }
        res = res * bamboo_len % MOD;
        return (int) res;
    }
}
