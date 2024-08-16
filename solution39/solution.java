package solution.solution39;

import java.util.HashMap;
import java.util.Map;

// 找到出现次数超过一半是数字
// 摩尔排序 每个不同的数字抵消 最后剩下的就是超过一半的
class solution {
    public int inventoryManagement(int[] stock) {
        // 记录出现次数
        int count = 0;
        int res = 0;
        for (int i = 0; i < stock.length; i++) {
            // 前面抵消完了 记录新的可能数字
            if (count == 0) {
                res = stock[i];
            }
            if (res == stock[i]) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}

// 普通 Map
class solution1 {
    public int inventoryManagement(int[] stock) {
        Map<Integer,Integer> set = new HashMap<>();
        for (int s : stock) {
           set.put(s, set.getOrDefault(s, 0) + 1);
           if (set.get(s) >= stock.length/2) {
               return s;
           }
        }
        return 0;
    }
}
