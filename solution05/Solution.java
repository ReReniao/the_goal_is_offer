package solution.solution05;

class Solution {
    public String pathEncryption(String path) {
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < path.length(); i++) {
           if (path.charAt(i) == ' ') {
              sb.append("%20");
           } else {
              sb.append(path.charAt(i));
           }
       }
       return sb.toString();
    }
}
