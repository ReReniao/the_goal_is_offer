package solution.solution65;

/*
    不使用加减号计算加法
 */

// a & b 在两个数字的位都为1时为1 否则为0
// a ^ b 在两个数字不一样时为1
// 在二进制展开的数字上考虑 两个数字相加 等于 (a&b)<<1 +a^b
class Solution {
    public int encryptionCalculate(int dataA, int dataB) {
        while (dataB!=0) {
            int plus = dataA^dataB;
            int cur = dataA&dataB;
            dataA = plus;
            dataB = cur<<1;
        }
        return dataA;
    }
}
