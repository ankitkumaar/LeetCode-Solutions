class Solution {
    public long countGood(int[] nums, int k) {
        
        long count = 0, pairs = 0;
        int start = 0, end = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while (end < nums.length) {
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);
            pairs += freqMap.get(nums[end]) - 1;
            
            /* Shrink the window until the number of pairs is less than k */
            while (pairs >= k) {
                count += nums.length - end;
                freqMap.put(nums[start], freqMap.get(nums[start]) - 1);
                pairs -= freqMap.get(nums[start]);
                start++;
                }
            end++;
            }
        return count;
    }
}