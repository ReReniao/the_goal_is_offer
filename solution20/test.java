package solution.solution20;

class Solution {
    public boolean validNumber(String s) {
        // 去除空格
//        String newStr = s.strip();
        int left = 0,right = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
               break;
            }
            left++;
        }
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
            right--;
        }
        if (left > right) {
            return false;
        }
        // 左闭右开
        s = s.substring(left,right+1);
        s = s.replace('e','E');
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) != 'E') {
            idx++;
        }
        if (idx == s.length()) {
            return isValid(s,true);
        } else {
            return isValid(s.substring(0,idx),true) && isValid(s.substring(idx+1),false);
        }
    }

    private boolean isValid(String s,Boolean allowDot) {
        boolean hasNum = false;
        boolean hasDot = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (s.charAt(i) == '.') {
                if (!allowDot) {
                    return false;
                }
                if (hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }

}