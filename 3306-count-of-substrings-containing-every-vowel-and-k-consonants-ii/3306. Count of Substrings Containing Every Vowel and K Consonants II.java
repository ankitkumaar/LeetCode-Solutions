class Solution {
    public long countOfSubstrings(String word, int k) {

        long numValidSubstrings = 0;
        int start = 0, end = 0;
        
        /* HashMap to keep track of vowel counts in the current window */
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        /* Array to store the next consonant index for each position in the string */
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();

        /* Traverse the string from the end to precompute the next consonant index */
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            
            /* If the current character is a consonant, update the next consonant index */
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        /* Expand the window using the end pointer */
        while (end < word.length()) {
            char newLetter = word.charAt(end);

            /* If the character is a vowel, update its count in the map */
            if (isVowel(newLetter)) {
                vowelCount.put(newLetter, vowelCount.getOrDefault(newLetter, 0) + 1);
            }
            /* If the character is a consonant, increment the consonant count */
            else {
                consonantCount++;
            }

            /* Shrink the window from the left if consonant count exceeds k */
            while (consonantCount > k) {
                char startLetter = word.charAt(start);

                if (isVowel(startLetter)) {
                    vowelCount.put(startLetter, vowelCount.get(startLetter) - 1);
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            /* Count valid substrings when all vowels are present and 
            consonant count is exactly k */
            while (
                start < word.length() &&
                vowelCount.keySet().size() == 5 && /* Ensure all vowels are present */
                consonantCount == k
            ) {
                
                /* Increment the count by the number of 
                valid substrings ending at 'end' */
                numValidSubstrings += nextConsonant[end] - end;
                
                /* Move the start pointer to shrink the window */
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(startLetter, vowelCount.get(startLetter) - 1);
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }
            /* Move the end pointer to expand the window */
            end++;
        }
        return numValidSubstrings;
    }

    /* Helper function to check if a character is a vowel */
    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');   
    }
}