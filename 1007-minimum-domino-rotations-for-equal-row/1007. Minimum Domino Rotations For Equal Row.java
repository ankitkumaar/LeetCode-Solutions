class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        /* Array to count the frequency of each number in both arrays */
        int[] freq = new int[7];
        for (int i = 0; i < tops.length; i++) {
            freq[tops[i]]++;
            freq[bottoms[i]]++;
        }

        /* Find the number with the maximum frequency */
        int max = 0, num = 0;
        for (int i = 1; i < 7; i++) {
            if (max < freq[i]) {
                max = freq[i];
                num = i;
            }
        }

        /* Check if it's possible to make all values 
        in tops or bottoms equal to num */
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != num && bottoms[i] != num)
                return -1;
        }

        /* Count the number of rotations needed */
        int count1 = 0, count2 = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != num)
                count1++;
            if (bottoms[i] != num)
                count2++;
        }

        /* Return the minimum number of rotations needed */
        return Math.min(count1, count2);
    }
}
