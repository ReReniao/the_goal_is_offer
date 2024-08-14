package solution.solution17;

class solution {
    public int[] countNumbers(int cnt) {
        double maxNum = Math.pow(10,cnt);
        int[] nums = new int[(int) maxNum - 1];
        for (int i = 1; i < maxNum; i++) {
            nums[i-1] = i;
        }
        return nums;
    }
}
