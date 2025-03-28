class Solution {
    public int minimumIndex(List<Integer> nums) {
        
        int dom = 0, count = 0, n = nums.size();
        Map<Integer, Integer> hmap = new HashMap<>();

        /* Count the occurrences of each number in the list */
        for (int i=0; i<n; i++) {
            hmap.put(nums.get(i), hmap.getOrDefault(nums.get(i), 0) + 1);
        }

        /* Identify the dominant element (appears more than n/2 times) */
        for (Map.Entry<Integer, Integer> hm : hmap.entrySet()) {
            if (hm.getValue() > n/2) {
                dom = hm.getKey(); count = hm.getValue();
                break;
            }
        }

        int leftCount = 0;
        
        /* Find the minimum index where both partitions satisfy the condition */
        for (int i=0; i<n-1; i++) {
            if (nums.get(i) == dom) 
                leftCount++;
            
            int leftSize = i + 1;
            int rightSize = n - leftSize;
            int rightCount = count - leftCount;

            /* Check if `dom` is dominant in both left and right partitions */
            if (leftCount > leftSize / 2 && rightCount > rightSize / 2) {
                return i;
            }
        }
        return -1;
    }
}