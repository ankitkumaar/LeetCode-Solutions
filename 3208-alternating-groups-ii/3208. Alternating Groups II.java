class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int freq = 0, count = 0;
        /* Loop runs twice the length of the array to simulate circular behavior */
        for (int i=0; i < 2*colors.length; i++) {

            /* If the current color is the same as the previous one, reset the count to 1
            Otherwise, continue counting consecutive alternating elements */
            if (i > 0 && colors[i % colors.length] == colors[(i - 1) % colors.length])
                count = 1;
            else
                count++;

            /* Check if we have completed one full cycle and found a 
            valid alternating group of size >= k */
            freq += (i >= colors.length && count >= k) ? 1 : 0;
        }
        return freq;
    }
}