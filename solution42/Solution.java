package solution.solution42;

/*
    连续子序列的最大和
 */

class Solution {
    // 贪心
    public int maxSales(int[] sales) {
        int maxSum = sales[0];
        int sum = 0;
        for (int i = 0; i < sales.length; i++) {
            // 每次都将当前值添加到sum中 sum相当于是以下标i结尾的子序列的最大值
            sum += sales[i];
            // 动态地更新最大和
            if (sum > maxSum) {
                maxSum = sum;
            }
            // 贪心关键 如果和已经小于0，不会再出现更大的值
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    // dp
    public int maxSales1(int[] sales) {
        // 根据贪心sum的意义 我们可以通过前一个下标i-1的子序列最大值求得当前i的最大值 可以使用dp
        // dp[i] = max(sales[i],dp[i-1]+sales[i]) dp[0] = sales[0]
        int cur = sales[0];
        int res = cur;
        for (int i = 1; i < sales.length; i++) {
            cur = max(sales[i], cur+sales[i]);
            if (cur > res) {
                res = cur;
            }
        }
        return cur;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}