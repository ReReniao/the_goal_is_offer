package solution.solution67;

class Solution {
    public int myAtoi(String str) {
        int numStart = 0;
        long res = 0;
        int negative = 1;
        boolean seenNum = false;
        for (; numStart < str.length(); numStart++) {
            if (str.charAt(numStart) != ' ') {
                break;
            }
        }
        if (numStart == str.length()) {
            return 0;
        }
        for (int i = numStart; i < str.length(); i++) {
            // 符号位一定是在第一位
            if ((str.charAt(i) == '+' || str.charAt(i) == '-') && i == numStart) {
                if (str.charAt(i) == '-') {
                    negative = -1;
                }
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                // 原数乘10 + 个位
                if (!seenNum) {
                    seenNum = true;
                }
                res *= 10;
                res += str.charAt(i) - '0';
            } else {
                if (!seenNum) {
                    return 0;
                } else {
                    break;
                }
            }
            if (res > Integer.MAX_VALUE) {
                if (negative == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
        }
        if (negative == -1) {
            return (int) (negative*res);
        }
        return (int) res;
    }
}


public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myAtoi("2147483646");
    }
}