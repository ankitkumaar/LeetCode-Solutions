class Solution {
    public String triangleType(int[] nums) {

        /* A triangle is possible or not */
        if(!(nums[0] + nums[1] > nums[2] && nums[1] + nums[2] > nums[0] 
            && nums[0] + nums[2] > nums[1]))
            return "none";

        /* A triangle is equilateral if it has all sides of equal length */
        if(nums[0] == nums[1] && nums[1] == nums[2])
            return "equilateral";

        /* A triangle is isosceles if it has exactly two sides of equal length */
        if(nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
            return "isosceles";

        return "scalene";
    }
}