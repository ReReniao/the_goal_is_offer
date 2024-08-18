package solution.solution31;

import java.util.ArrayList;
import java.util.List;

/*
验证一对出入栈的序列是否是合理的
 */

class Solution {
    // 使用一个栈模拟
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        List<Integer> stack = new ArrayList<>();
        int OutPointer = 0;
        for (int j : putIn) {
            stack.add(j);
            while (OutPointer<takeOut.length && !stack.isEmpty() && takeOut[OutPointer] == stack.getLast()) {
                stack.removeLast();
                OutPointer++;
            }
        }
        // 如果最后栈为空 则表示合理
        return stack.isEmpty();
    }

    // 优化空间
    // 直接将putIn数组作为模拟用的栈
    public boolean validateBookSequences1(int[] putIn, int[] takeOut) {
        int InP = 0,OutP = 0;
        int topP = -1;
        while (InP < putIn.length) {
            // 入栈
            topP++;
            putIn[topP] = putIn[InP];
            while (OutP < takeOut.length && topP >= 0 && putIn[topP] == takeOut[OutP]) {
                topP--;
                OutP++;
            }
            InP++;
        }
        return topP == -1;
    }
}


