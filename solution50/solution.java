package solution.solution50;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public char dismantlingAction(String arr) {
        // 字符串都是小写字母，记录出现次数
        int[]  seenTimes = new int[26];
        for (int i = 0; i < arr.length(); i++) {
            seenTimes[arr.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length(); i++) {
            if (seenTimes[arr.charAt(i) - 'a'] == 1) {
                return arr.charAt(i);
            }
        }
        return ' ';
    }
}

class Solution1 {
    public char dismantlingAction(String arr) {
        // 字符串都是小写字母，记录出现次数
        Map<Character, Integer[]> map = new HashMap<>();
        for (int i = 0; i < arr.length(); i++) {
            if (!map.containsKey(arr.charAt(i))) {
                map.put(arr.charAt(i), new Integer[]{i, 1});
            } else {
                map.put(arr.charAt(i),new Integer[]{map.get(arr.charAt(i))[0],++map.get(arr.charAt(i))[1]});
            }
        }
        int min = arr.length();
        for (Map.Entry<Character, Integer[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == 1) {
                min = min > entry.getValue()[0] ? entry.getValue()[0] : min;
            }
        }
        if (min == arr.length()) {
            return ' ';
        }
        return arr.charAt(min);
    }
}


public class solution {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.dismantlingAction("ccdd");
    }
}