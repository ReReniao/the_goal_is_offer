package solution.solution11;

public class solution {
    public int stockManagement(int[] stock) {
        int left = 0;
        int right = stock.length-1;
        while (left < right) {
            int mid = left + (right - left) >>1;
            if (stock[mid] < stock[right]) {
                right = mid;
            } else if (stock[mid] > stock[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return stock[left];
    }
}
