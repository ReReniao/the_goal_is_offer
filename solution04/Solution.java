package solution.solution04;

public class Solution {
        public boolean findTargetIn2DPlants(int[][] plants, int target) {
            if(plants == null || plants.length == 0) {
                return false;
            }
            int m = 0;
            int n = plants[0].length-1;
            while (m < plants.length && n >= 0) {
                if (plants[m][n] == target) {
                    return true;
                } else if (plants[m][n] < target) {
                    m++;
                } else if (plants[m][n] > target) {
                    n--;
                }
            }
            return false;
        }
}
