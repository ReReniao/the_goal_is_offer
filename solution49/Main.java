package solution.solution49;

class solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        for (int i = 1; i < n; i++) {
            int next = Math.min(ugly[i2]*2, Math.min(ugly[i3]*3, ugly[i5]*5));
            ugly[i] = next;
            if (ugly[i2]*2 == next) {
                i2++;
            }
            if (ugly[i3]*3 == next) {
                i3++;
            }
            if (ugly[i5]*5 == next) {
                i5++;
            }
        }
        return ugly[n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        solution solution = new solution();
        solution.nthUglyNumber(10);
    }
}
