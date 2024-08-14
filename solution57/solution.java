package solution.solution57;

class solution {
    public int[] twoSum(int[] price, int target) {
        int left = 0,right = price.length-1;
        while (left < right) {
            int sum = price [left] + price [right];
            if (sum == target) {
                return new int[] {left+1, right+1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}