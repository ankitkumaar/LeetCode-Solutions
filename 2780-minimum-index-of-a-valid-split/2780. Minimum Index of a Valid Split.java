class Solution {
    public int minimumIndex(List<Integer> nums) {
        
        /* 'x' stores the dominant element, 'cnt' keeps track of its count
        HashMap to store the frequency of each element */
        int x = 0, cnt = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        /* First pass: Find the dominant element 
        (The one that appears most frequently) */
        for (int v : nums) {
            int t = freq.merge(v, 1, Integer::sum); 
            
            /* Update dominant element if 'v' appears more frequently */
            if (cnt < t) {
                cnt = t; x = v;
            }
        }

        /* Count of 'x' encountered so far
        Second pass: Find the minimum index where the array can be split */
        int cur = 0;
        for (int i = 1; i <= nums.size(); ++i) {
            
            /* If the current element is the dominant one */
            if (nums.get(i - 1) == x) {
                cur++;
                
                /* Check if 'x' remains the dominant element 
                in both halves after the split */
                if (cur * 2 > i && (cnt - cur) * 2 > nums.size() - i)
                    return i - 1;
            }
        }
        return -1;
    }
}