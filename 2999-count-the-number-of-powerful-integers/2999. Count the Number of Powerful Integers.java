class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        
        /* Convert the range boundaries to strings for digit-wise manipulation */
        String low = Long.toString(start - 1);
        String high = Long.toString(finish);

        /* Calculate the count of valid numbers between [start, finish] */
        return calculate(high, s, limit) - calculate(low, s, limit);
    }

    /* Helper function that returns how many valid numbers <= x exist */
    private long calculate(String x, String s, int limit) {
        
        /* If x has fewer digits than s, so return 0 */
        if (x.length() < s.length())
            return 0;

        /* If x has the same number of digits as s, just compare directly */
        if (x.length() == s.length())
            return x.compareTo(s) >= 0 ? 1 : 0;

        /* Extract the suffix of x to compare with s later
        Number of digits before the suffix */
        String suffix = x.substring(x.length() - s.length());
        int preLen = x.length() - s.length();
        long count = 0;

        /* Loop through the prefix digits of x */
        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';

            /* If the current digit exceeds the limit, 
            all numbers from here would be valid */
            if (limit < digit) {
                count += (long)Math.pow(limit + 1, preLen - i);
                return count;
            }

            /* Add all combinations where 
            current digit is less than current digit in x */
            count += (long)(digit) * (long)Math.pow(limit + 1, preLen - 1 - i);
        }

        /* After prefix is matched, check if the suffix is >= s
        Count the number x itself */
        if (suffix.compareTo(s) >= 0) {
            count++;
        }

        /* Total valid numbers <= x */
        return count;
    }
}