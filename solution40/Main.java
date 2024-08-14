package solution.solution40;

import java.util.PriorityQueue;

class solution {
    public int[] inventoryManagement(int[] stock, int cnt) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2-o1) {};
        for (int j : stock) {
            pq.add(j);
        }
        int[] result = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public int[] inventoryManagement2(int[] stock, int cnt) {
        partiton(stock,0,stock.length-1,cnt);
        int[] result = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            result[i] = stock[i];
        }
        return result;
    }

    private void partiton(int[] stock,int s, int e,int cnt) {
        // 递归终点
        if (s >= e) {
            return;
        }
        int pivot = stock[s];
        int left = s,right = e;
        while (left < right) {
            while (left < right && stock[right] >= pivot) {
                right--;
            }
            stock[left] = stock[right];
            while (left < right && stock[left] <= pivot) {
                left++;
            }
            stock[right] = stock[left];
        }
        stock[left] = pivot;
        if (left == cnt-1) {
            return;
        } else if (left > cnt-1){
            partiton(stock,s,left-1,cnt);
        } else {
            partiton(stock,left+1,e,cnt);
        }
    }
}
