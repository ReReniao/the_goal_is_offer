package solution.solution46;

/*
    将数字翻译成字符串的结果数 a~z 对应0~25
 */

class Solution {
    // dp
    public int crackNumber(int ciphertext) {
        String str = Integer.toString(ciphertext);
        // dp[i]表示到下标i为止最多翻译结果
        int[] dp = new int[str.length()];
        // 一个字母至多一种结果
        dp[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            int number = (str.charAt(i)-'0')+(str.charAt(i-1)-'0')*10;
            // 两位数表示当前数字可以有两种翻译结果
            if (number>=10 && number<=25) {
                if (i == 1) {
                    dp[i] = 2;
                } else {
                    // 例如 123的3 取23时 种类数为1下标的种类 取3时 种类数为2下标的种类
                    dp[i] = dp[i-1] + dp[i-2];
                }
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[str.length()-1];
    }
}
