package solution.solution43;

class solution {
    public int digitOneInNumber(int num) {
        String string = Integer.toString(num);
        int length = string.length();
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            int high = (int) (num / Math.pow(10,length-i));
            int low = (int) (num % Math.pow(10,length-i-1));
            double zero = high * Math.pow(10, length - i - 1);
            if (string.charAt(i) == '1') {
                result += (int)zero +low+1;
            } else if (string.charAt(i) < '1') {
                result += (int) zero;
            } else {
                result += (int) ((int) zero + Math.pow(10,length-i-1));
            }
        }
        return result;
    }
}