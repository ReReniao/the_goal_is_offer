package solution.solution48;

class Solution {
    public int dismantlingAction(String arr) {
        // 记录出现次数
        int[] freq = new int[127];
        int res = 0;
        // right 取-1为了包括窗口为1的情况
        int left = 0, right = -1;
        while (left < arr.length()) {
            // 右边第一次遍历到或者已经到右边界，次数+1,窗口扩张一位
            if (right+1 < arr.length() && freq[arr.charAt(right+1)] == 0) {
                freq[arr.charAt(right+1)]++;
                right++;
            } else {
                // 遍历到已经遍历过的，缩小窗口，直到与右边相同的移出窗口
                freq[arr.charAt(left)]--;
                left++;
            }
            // 过程中记录窗口长度
            res = max(res, right - left + 1);
        }
        return res;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
