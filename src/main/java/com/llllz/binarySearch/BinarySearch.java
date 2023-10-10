package com.llllz.binarySearch;

/**
 * @create 2023-10-10-16:48
 */
public class BinarySearch {
    public static void main( String[] args )
    {
        int[] nums = new int[]{1,2,3,5,6,7};
//        int search0 = binarySearch0(nums, 3);
//        System.out.println(search0);
        int[] num = new int[]{1,2,3,3,3,5,6,7};
        int leftMost = leftMost(num, 3);
        int rightMost = rightMost(num, 3);
        System.out.println("最左索引:" + leftMost + ", 最右索引:" + rightMost);

    }

    /**
     * 基础版(给定数组，给定目标值，找到目标值所在位置下标，若没有，则返回-1)
     */
    public static int binarySearch0(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) >>> 1;
//            int mid = (low + high) / 2;
            if(target < nums[mid]){                     //在左边
                high = mid - 1;
            } else if (nums[mid] < target) {            //在右边
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * leftmost
     * 注：当有序数组中存在 重复元素时，选用此方法(找到重复元素最左索引)
     */
    public static int leftMost(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int candidate = -1;                             //记录候选位置
        while (low <= high){
            int mid = (low + high) >>> 1;
//            int mid = (low + high) / 2;
            if(target < nums[mid]){                     //在左边
                high = mid - 1;
            } else if (nums[mid] < target) {            //在右边
                low = mid + 1;
            } else {
                candidate = mid;
                high = mid -1;
            }
        }
        return candidate;
    }

    /**
     * rightmost
     * 注：当有序数组中存在 重复元素时，选用此方法(找到重复元素最右索引)
     */
    public static int rightMost(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int candidate = -1;                             //记录候选位置
        while (low <= high){
            int mid = (low + high) >>> 1;
//            int mid = (low + high) / 2;
            if(target < nums[mid]){                     //在左边
                high = mid - 1;
            } else if (nums[mid] < target) {            //在右边
                low = mid + 1;
            } else {
                candidate = mid;
                low = mid + 1;
            }
        }
        return candidate;
    }
}
