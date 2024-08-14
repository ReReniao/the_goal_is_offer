package solution.solution21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class solution {
    public int[] trainingPlan(int[] actions) {
        int left = 0, right = actions.length - 1;
        while (left < right) {
            if ((actions[left]&1)==0 && (actions[right]&1)==1) {
                int temp = actions[left];
                actions[left] = actions[right];
                actions[right] = temp;
                left++;
                right--;
            }
            if ((actions[left]&1)==1 && (actions[right]&1)==1) {
                left++;
            }
            if ((actions[left]&1)==0 && (actions[right]&1)==0) {
                right--;
            }
            if ((actions[left]&1)==1 && (actions[right]&1)==0) {
                left++;
                right--;
            }
        }
        return actions;
    }
}

class solution1 {
    public int[] trainingPlan(int[] actions) {
        int left = 0, right = actions.length - 1;
        while (left < right) {
            // 从左边找第一个不为奇数的
            while (left < right && (actions[left]&1)==1) {
                left++;
            }
            // 从右边找第一个不为偶数的
            while (left < right && (actions[right]&1)==0) {
                right--;
            }
            // 交换
            if (left < right) {
                int temp = actions[left];
                actions[left] = actions[right];
                actions[right] = temp;
            }
        }
        return actions;
    }
}