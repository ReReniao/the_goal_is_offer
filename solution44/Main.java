package solution.solution44;

class solution {
    public int findKthNumber(int k) {
        // 序列012345678910111213...n
        if (k == 0) {
            return 0;
        }
        // bits 表示当前遍历的数字字符位数，cnt表示该数字之前的字符总数
        int bits = 1;
        long cnt = 1;
        while (k>=bits) {
            long start = (int) Math.pow(10,bits-1);
            long nextCnt = cnt+start*9*bits;
            if (k<=nextCnt) {
                long num = start+(k-cnt)/bits;
                int bit = (int) ((k-cnt) % bits);
                return Long.toString(num).charAt(bit)-'0';
            }
            cnt = nextCnt;
            bits++;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        solution solution = new solution();
        solution.findKthNumber(1000000000);
    }
}

/* 数字范围    数量  位数    占多少位
    1-9        9      1       9
    10-99      90     2       180
    100-999    900    3       2700
    1000-9999  9000   4       36000  ...

    例如 2901 = 9 + 180 + 2700 + 12 即一定是4位数,第12位   n = 12;
    数据为 = 1000 + (12 - 1)/ 4  = 1000 + 2 = 1002
    定位1002中的位置 = (n - 1) %  4 = 3    s.charAt(3) = 2;
*/

// 优化版
class Solution {
    public int findNthDigit(int n) {
        if (n == 0) {
            return n;
        }
        int digit = 1;   // n所在数字的位数
        long start = 1;  // 数字范围开始的第一个数
        long count = 9;  // 占多少位
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        // n从0开始，但start从1开始
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
