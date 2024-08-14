package solution.solution53;

class solution {
    public int countTarget(int[] scores, int target) {
        int left = binarySearch(scores,target,true);
        if (left == -1) {
            return 0;
        }
        int right = binarySearch(scores,target,false);
        return right-left+1;
    }

   private int binarySearch(int[] scores, int target, boolean isLeftSearch) {
        int left = 0, right = scores.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (scores[mid] == target) {
                if (isLeftSearch) {
                    res = mid;
                    right = mid - 1;
                } else {
                    res = mid;
                    left = mid + 1;
                }
            } else if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}


class solution1 {
    public int takeAttendance(int[] records) {
        int left = 0,right = records.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (records[mid] == mid) {
                left = mid + 1;
            } else if (records[mid] > mid) {
                right = mid;
            }
        }
        return left;
    }
}