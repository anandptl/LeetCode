class Solution {
    private void revers(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %=n;

        revers(nums, 0, n-1);
        revers(nums, 0, k-1);
        revers(nums, k, n-1);

    }
}