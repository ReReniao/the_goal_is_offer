package solution.solution11;

/*
    查找旋转数组的最小数字
 */

// 根据性质最小和最大都出现在交界处 即变得无序的部分
// 二分查找 迭代到无序部分
class Solution {
    public int stockManagement(int[] stock) {
        int left = 0;
        int right = stock.length-1;
        while (left < right) {
            int mid = left + (right - left) >>1;
            // 中间值小于最右值 说明右边有序 则左边可能无序
            if (stock[mid] < stock[right]) {
                right = mid;
                // 中间值大于最右值 显然右边无序
            } else if (stock[mid] > stock[right]) {
                left = mid + 1;
                // 无法判断 但是可以减少一个相同的值
            } else {
                right--;
            }
        }
        return stock[left];
    }
}

class Solution1 {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = left + ((right - left) >>1);
            // 中间值小于最右值 说明右边有序 则左边可能无序
            if (arr[mid] < arr[right]) {
                right = mid;
                // 中间值大于最右值 显然右边无序
            } else if (arr[mid] > arr[right]) {
                left = mid + 1;
                // 无法判断 但是可以减少一个相同的值
            } else {
                right--;
            }
        }
        int split =  left;
        if (arr[split]< target && arr[arr.length-1] > target) {
            return BinarySearch(arr,target,split,arr.length-1);
        } else {
            return BinarySearch(arr,target,0,split-1);
        }
    }

    private int BinarySearch(int[] arr, int target,int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            int mid = left + ((right - left) >>1);
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

public class test {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.search(new int[]{1,1,1,1,1,2,1,1,1},5);
    }
}