class Solution {
    public int countSymmetricIntegers(int low, int high) {

        int count = 0;

        /* Iterate through each integer from low to high */
        while(low <= high)   {

            /* Convert the current number to a string */
            String start = Integer.toString(low);

            /* Only consider numbers with an even number of digits */
            if(start.length() % 2 == 0)   {

                int sumFirst = 0, sumLast = 0;
                int half = start.length() / 2;

                /* Loop through the first half of the digits */
                for(int i = 0; i < half; i++)   {
                    
                    /* Add digit values from the first and second halves */
                    sumFirst += start.charAt(i) - '0';
                    sumLast += start.charAt(i + half) - '0';
                }

                /* If both halves have equal sums, it's a symmetric integer */
                if(sumFirst == sumLast)
                    count++;
            }
            low++;
        }
        return count;
    }
}