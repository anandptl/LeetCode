class Solution {

    public int missingInteger(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store all numbers
        for (int num : nums) {
            set.add(num);
        }

        // Sequential prefix sum
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find smallest missing integer > sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}