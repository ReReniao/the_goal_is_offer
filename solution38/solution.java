package solution.solution38;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] goodsOrder(String goods) {
        char[] str = goods.toCharArray();
        Arrays.sort(str);
        goods = new String(str);
        ArrayList<String> res = new ArrayList<String>();
        boolean[] used = new boolean[goods.length()];
        StringBuilder sb = new StringBuilder();
        backtracking(goods,sb,res,used);
        return res.toArray(new String[res.size()]);
    }

    private void backtracking(String goods,StringBuilder path,ArrayList<String> res,boolean[] used) {
        if (path.length() == goods.length()) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < goods.length(); i++) {
            // || 前是为了同一深度（树层）去重， || 后是为了避免深度优先时（树枝）选同一个
            if (i > 0 && goods.charAt(i) == goods.charAt(i-1) && !used[i-1] || used[i]) {
                continue;
            }
            used[i] = true;
            path.append(goods.charAt(i));
            backtracking(goods,path,res,used);
            used[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
}
