class Solution {
    public int[] findEvenNumbers(int[] digits) {

        /* Frequency array to count occurrences of each digit (0-9) in array */
        int[] freq = new int[10];
        for(int i = 0; i < digits.length; i++)   {
            freq[digits[i]]++;
        }
        
        /* List to store valid 3-digit even numbers */
        List<Integer> li = new ArrayList<>();

        /* Iterate through all 3-digit even numbers */
        for(int num = 100; num < 999; num+=2)   {

            /* Store each digits of number */
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            /* Store original frequencies to restore later */
            int f1 = freq[a], f2 = freq[b], f3 = freq[c];

            /* Check if all digits are available in the input array */
            if(freq[a]-- != 0 && freq[b]-- != 0 && freq[c]-- != 0)
                li.add(num);
            
            /* Restore original frequencies for the next iteration */
            freq[a] = f1;   freq[b] = f2;   freq[c] = f3;
        }

        /* Convert the list of integers to an array */
        int[] ans = new int[li.size()];
        for(int i = 0; i < ans.length; i++)   {
            ans[i] = li.get(i);
        }
        return ans;
    }
}