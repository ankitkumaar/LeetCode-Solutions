class Solution {
    public long maximumTripletValue(int[] nums) {
        
        long ans = 0, diffMax = 0, max = 0;
        for(int num : nums)   {
            ans = Math.max(ans, diffMax * num);
            diffMax = Math.max(diffMax, max - num);
            max = Math.max(max, num);
        }
        return ans;
    }
}