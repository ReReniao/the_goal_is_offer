package solution.solution03;

import java.util.HashSet;

// 普通哈希表
public class Solution {
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}

// 空间复杂度低
class Solution1 {
    public static int findRepeatNumber(int[] documents) {
        for (int i=0; i<documents.length; i++) {
            for (; documents[i] != i; ) {
                if (documents[i] != documents[documents[i]]) {
                    int temp = documents[i];
                    documents[i] = documents[temp];
                    documents[temp] = temp;
                } else {
                    return documents[i];
                }
            }
        }
        return -1;
    }
}
