package solution.solution10;

/*
    斐波那契数列
 */

class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int pre = 0;
        int cur = 0;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            pre = cur;
            cur = res;
            res = (pre + cur)&1000000007;
        }
        return cur;
    }
}

/*
    跳格子
 */
class Solution1 {
    public int trainWays(int num) {
        int pre = 1;
        int cur = 1;
        int sum = 2;
        for (int i = 0; i <= num; i++) {
            sum = (pre + cur)%1000000007;
            pre = cur;
            cur = sum;
        }
        return pre;
    }
}