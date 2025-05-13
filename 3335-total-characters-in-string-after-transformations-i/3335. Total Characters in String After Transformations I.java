class Solution {
    public int lengthAfterTransformations(String s, int t) {

        /* A large prime number to take modulo and prevent integer overflow */
        /* Array to store frequency of each lowercase letter (a-z) */
        final int mod = 1000000007;
        int[] freq = new int[26];
        
        /* Count the frequency of each character in the input string */
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        /* Perform the transformation 't' times */
        while (t-- > 0) {

            /* Array to store updated frequencies after transformation */
            int[] nextNum = new int[26];
            nextNum[0] = freq[25];
            nextNum[1] = (freq[25] + freq[0]) % mod;
            
            /* For other characters, shift frequency from previous character */
            for (int i = 2; i < freq.length; i++) {
                nextNum[i] = freq[i - 1];
            }

            /* Update the frequency array for the next iteration */
            freq = nextNum;
        }

        /* Sum all frequencies to get the final length 
        after transformations */
        int sum = 0;
        for (int num : freq) {
            sum = (sum + num) % mod;
        }
        return sum;
    }
}