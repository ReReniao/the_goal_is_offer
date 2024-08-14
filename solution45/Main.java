package solution.solution45;

import java.util.*;

class solution {
    public String crackPassword(int[] password) {
        List<String> list = new ArrayList<>();
        for (int j : password) {
            list.add(String.valueOf(j));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s :list) {
            sb.append(s);
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        solution solution = new solution();
        solution.crackPassword(new int[]{15,8,7});
    }
}
