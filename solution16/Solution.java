package solution.solution16;

import java.util.HashMap;
import java.util.Map;

/*
不使用库函数实现整数次幂
 */

class Solution {
    Map<Integer, Double> memo;

    // 记忆化搜索
    public double myPow(double x, int n) {
        memo = new HashMap<>();
        memo.put(0, 1.0);
        memo.put(1, x);
        return helper(x,n);
    }

    double helper (double x, long n) {
        if (n <0) {
            return 1.0/helper(x,-n);
        }
        if (!memo.containsKey((int)n)) {
            long half_n = n/2;
            memo.put((int)n, helper(x,half_n)*helper(x,n-half_n));
        }
        return memo.get((int)n);
    }

    // 快速幂
    double quickMul(double x, long n) {
        double res = 1;
        if (n < 0) {
            res = 1 / quickMul(x,-n);
        }
        while (n!=0) {
            if (n%2==1) {
                res*=  x;
            }
            x*=x;
            n = n/2;
        }
        return res;
    }
}