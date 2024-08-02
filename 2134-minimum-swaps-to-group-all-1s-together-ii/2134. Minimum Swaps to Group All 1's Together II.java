class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        // Iterate for total number of 1's in array
        for (int num : nums) {
            k += num;
        }

        int count = 0, n = nums.length;
        // Initial count of 1 in first window
        for (int i=0; i<k; i++) {
            count += nums[i];
        }

        int maxCount = 0;
        // Use sliding window to count all window of size k
        for (int i=k; i<n+k; i++) {
            count += nums[i % n] - nums[(i - k + n) % n];
            maxCount = Math.max(maxCount, count);
        }

        return k - maxCount;
    }
}