package solution.solution58;

class Solution {
    public String reverseMessage(String message) {
       char[] chars = message.toCharArray();
       // 去除前导空格
        int slow = 0, fast = 0;
        while (fast < chars.length) {
            // 遇到单词
            if (chars[fast] != ' ') {
                if (slow != 0) {
                    chars[slow] = ' ';
                    slow++;
                }
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow] = chars[fast];
                    slow++;
                    fast++;
                }
            } else {
                fast++;
            }
        }
        // 翻转
        reverse(chars,0,slow-1);
        int left = 0, right = 0;
        while (right < slow-1) {
            if (right < slow-1 && chars[right] == ' ') {
                reverse(chars,left,right-1);
                left = right+1;
            }
            right++;
        }
        reverse(chars,left,slow-1);
        return new String(chars).substring(0,slow);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseMessage("the sky is blue"));
    }
}

// 左旋转字符串
class Solution2 {
    public String dynamicPassword(String password, int target) {
        return password.substring(target)+ password.substring(0,target);
    }

    public String dynamicPassword1(String password, int target) {
        StringBuilder sb = new StringBuilder();
        for (int i = target; i < password.length(); i++) {
            sb.append(password.charAt(i));
        }

        for (int i = 0; i < target; i++) {
            sb.append(password.charAt(i));
        }

        return sb.toString();
    }
}