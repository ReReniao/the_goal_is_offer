package solution.solution15;

/*
    统计数字二进制表示的1的位数 即汉明重量，非零字符位数
 */
public class Solution {
    // you need to treat n as an unsigned value
    // 方法1 32位逐位于1 做&运算
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n = n>>1;
        }
        return res;
    }

    // 方法2 n & n-1 的结果是去除n的最低位1
    public int hammingWeight2(int n) {
        int res = 0;
        // 无符号整形基于使用n>0的终止条件
        while (n != 0) {
            res++;
            n &= n-1;
        }
        return res;
    }

    // 方法3 n & -n 整数的负数的补码实现在二进制表现为所有位取反后+1 &的结果相当于取最后lowBit
    public int hammingWeight3(int n) {
        int res = 0;
        // 无符号整形基于使用n>0的终止条件
        while (n != 0) {
            res++;
            n -= n&(-n);
        }
        return res;
    }
}
