package com.problem;

public class SearchInSortedRotatedArray {
    public static int findElement(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[start] <= nums[mid]) { // left array is sorted
                if (target >= nums[start] && target < nums[mid]) { // target lies between start and mid index
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // right array is sorted
                if (target > nums[mid] && target <= nums[end]) { // target lies between mid and end index
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            if (nums[left] == target) {
                result = left;
                break;
            } else if (nums[right] == target) {
                result = right;
                break;
            }
            left++;
            right--;
        }
        return result;
    }


    public static void main(String[] args) {
        int array[] = {4,5,6,7,0,1,2,3};
       System.out.println(findElement(array, 2));
      //  System.out.println(search(array,2));

    }
}
