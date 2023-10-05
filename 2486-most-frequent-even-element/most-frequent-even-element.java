class Solution 
{
    public int mostFrequentEven(int[] nums) 
    {
        // Create an array to store frequency of each number
        int[] freq = new int[1000001];
        // Traverse nums[]
        for(int ele : nums)
        {
            // Check number is even
            // Increment freq[] array by 1
            if (ele % 2 == 0)
                freq[ele]++;   
        }

        // Initialize max_Freq & max_Freq_Num 
        int max_Freq = 0;
        int max_Freq_Num = -1;
        // Iterate freq[]
        for(int i=0; i<freq.length; i++)
        {
            // Check if freq[i] is greater than max_Freq
            if (freq[i] > max_Freq)
            {
                // Store the nubers frequency and
                // Its index value
                max_Freq = freq[i];
                max_Freq_Num = i;
            }
        }
        // Return most frequent even number
        return max_Freq_Num;
    }
}