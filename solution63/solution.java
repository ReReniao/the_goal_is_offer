package solution.solution63;

// 暴力
class Solution1 {
    public int bestTiming(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit,prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }
}

class Solution {
    public int bestTiming(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            if (prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
