class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        /* Count initial 'W' in the first k-length window */
        int len = blocks.length();
        int count = 0, min = Integer.MIN_VALUE;
        for(int i=0; i<k; i++)   {
            if(blocks.charAt(i) == 'W')
                count++;
        }

        /* Initialize min with the count of 'W' in the first window */
        min = count;

        /* If the window already has all 'B', no need to recolor */
        if(count == 0)
            return 0;

        /* Left pointer for sliding window 
        Slide the window across the string */
        int j = 0;
        for(int i=k; i<len; i++)  {
            if(blocks.charAt(i) == 'W')
                count++;
            if(blocks.charAt(j) == 'W')
                count--;
            j++;

            /* Update minimum 'W' count required */
            min = Math.min(min, count);
            
            /* If we ever reach zero, no recoloring needed */
            if(min == 0)
                return 0;
        }
        return min;
    }
}