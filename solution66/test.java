package solution.solution66;

class solution {
    public int[] statisticalResult(int[] arrayA) {
        if (arrayA.length == 0) {
            return new int[0];
        }
       int[] prefix = new int[arrayA.length];
       prefix[0] = 1;
       for (int i = 1; i < arrayA.length; i++) {
           prefix[i] = prefix[i-1]*arrayA[i-1];
       }
       int temp = 1;
       for (int i = arrayA.length-1; i >= 0; i--) {
           prefix[i] = prefix[i]*temp;
           temp = temp*arrayA[i];
       }
       return prefix;
    }
}

public class test {
    public static void main(String[] args) {
        solution solution = new solution();
        solution.statisticalResult(new int[]{2, 4, 6, 8, 10});
    }
}