package solution.solution39;

import java.util.HashMap;
import java.util.Map;

// 摩尔排序
class solution {
    public int inventoryManagement(int[] stock) {
        int num = 0;
        int res = 0;
        for (int s : stock) {
            if (num == 0) {
                res = s;
            }
            if (s == res) {
                num++;
            } else {
                num--;
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
