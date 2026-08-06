import java.util.Scanner;

class Solution {
    public  int searchInsert(int[] nums, int target) {
        int f = 0;
        int l = nums.length-1;

        while (f <=l) {
            int mid = (f+l)/2;

            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                l = mid-1;
            }else{
                f = mid + 1;
            }
            
        }

        return l+1;
    }

    // public static void main(String[] args) {
    //     int nums[] = { 1, 3, 5, 6 };
    //     int target = 0;
    //     System.out.println(searchInsert(nums, target));
    // }
}