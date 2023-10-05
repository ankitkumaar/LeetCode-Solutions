class Solution 
{
    public int majorityElement(int[] nums) 
    {
        // Initialize count1 and count2 to store frequency
        // Initialize first and second variables
        int first = 0, second = 0, count1 = 0, count2 = 0;

        // Iterate through each array element
        for(int ele : nums)
        {
            // If first is equal to array element
            if (first == ele)
                count1++;
            
            // If first is equal to array element
            else if (second == ele)
                count2++;

            // If count1 is equal to 0
            // Increament count1
            else if (count1 == 0)
            {
                first = ele;
                count1++;
            }

            // If count2 is equal to 0
            // Increament count1
            else if (count2 == 0)
            {
                second = ele;
                count2++;
            }

            else
            {
                // Decrement count1 
                // And count2
                count1--;
                count2--;
            }
        }

        // Initialize count1 and couont2
        count1 = 0; count2 = 0;
        // Iterate through each array element
        for(int ele : nums)
        {
            // If first is equal to array element
            // Increment count1
            if (first == ele)
                count1++;

            // If second is equal to array element
            // Increment count2
            else if (second == ele)
                count2++;
        }

        // If count1 is greater than count2 & nums.length/3
        if ((count1 > count2) && count1 > (nums.length / 3))
            return first;

        // If count2 is greater than count1 & nums.length/3
        if ((count1 < count2) && count2 > (nums.length / 3))
            return second;
        return -1;
    }
}