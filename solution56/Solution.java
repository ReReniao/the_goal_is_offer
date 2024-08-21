package solution.solution56;

/*
在其余都是成对的数字中找到两个出现一次的数字
 */
// 按位分组 异或性质
class Solution {
    public int[] sockCollocation(int[] sockets) {
        int[] result = new int[2];
        int Two = sockets[0];
        // 相同数字异或为0 0异或任何数等于任何数
        // 结果是只出现一次的数字相互异或
        for (int i = 1; i < sockets.length; i++) {
            Two = Two ^ sockets[i];
        }
        // 异或结果中为1的位表示该位两个数字不一致，即一个为1，一个为0
        // 对于同一个数字 某一位一定是相同的
        // 根据该为把数字分成两组 那么肯定是成对的都在同一组 单个的不同组
        // 取某一非0位 采用lowBit 也可直接遍历
        int mask = Two & -Two;
        int ans1 = 0,ans2 = 0;
        for (int i = 0; i < sockets.length; i++) {
            if ((mask & sockets[i]) != 0) {
                ans1 ^= sockets[i];
            } else {
                ans2 ^= sockets[i];
            }
        }
        result[0] = ans1;
        result[1] = ans2;
        return result;
    }
}

/*
在其余都是3个一组的数字中找到只出现一次的数字
 */

class Solution1 {
    public int trainingPlan(int[] actions) {
        int res = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            for (int j = 0; j < actions.length; j++) {
                if ((actions[j] & mask) != 0) {
                    bits[i]++;
                }
            }
            if (bits[i] %3 == 1) {
                res += mask;
            }
        }
        return res;
    }
}