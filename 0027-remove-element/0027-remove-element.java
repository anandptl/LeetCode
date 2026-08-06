class Solution {
    public static int removeElement(int[] nums, int val) {
         int n = nums.length;
        int k = 0;
        for(int i = 0; i < n;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args){
        int nums[] = {1,2,3,4,5,6,7,6,2,8,9};
        int val = 6;
        removeElement(nums, val);
    }
}