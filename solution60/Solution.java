package solution.solution60;

/*
    有n个骰子 返回各个点数的概率
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    // 各种容器
    public double[] statisticsProbability(int num) {
        Map<Integer,Double> map = new HashMap<>();
        // 0个骰子的概率为1
        map.put(0,1.0);
        for (int i = 0; i < num; i++) {
            Iterator<Integer> iterator = map.keySet().iterator();
            Map<Integer,Double> newMap = new HashMap<>();
            while (iterator.hasNext()) {
                int key = iterator.next();
                for (int j = 1; j <= 6; j++) {
                    if (newMap.containsKey(key+j)) {
                        newMap.put(j+key, newMap.get(key+j) + map.get(key)/6.0);
                    } else {
                        newMap.put(j+key, map.get(key)/6.0);
                    }
                }
            }
            map = newMap;
        }
        double[] res = new double[5*num+1];
        for (int i = num; i <= 6*num; i++) {
            res[i-num] = map.get(i);
        }
        return res;
    }

    // 数组 提前计算容量
    public double[] statisticsProbability1(int num) {
        double[] dp = new double[6];
        Arrays.fill(dp,1/6.0);
        for (int i = 2; i < num; i++) {
            double[] newDp = new double[5*i+1];
            for (int j = 0; j <= dp.length-1; j++) {
                for (int k = 1; k <= 6; k++) {
                    newDp[j+k] += dp[j] / 6.0;
                }
            }
            dp = newDp;
        }
        return dp;
    }
}