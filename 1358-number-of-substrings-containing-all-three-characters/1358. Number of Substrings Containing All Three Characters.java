class Solution {
    public int numberOfSubstrings(String s) {
        
        /* Two-pointer approach with a sliding window
        HashMap to store the frequency of characters in the current window */
        int j = 0, count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        
        /* Iterate through the string using the right pointer */
        for(int i=0; i<s.length(); i++)   {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            /* When the window contains all three characters (a, b, and c) */
            while(hm.size() == 3)   {

                /* Add the count of valid substrings starting at index 'j'
                Get the leftmost character in the window */
                count += s.length() - i;
                char leftChar = s.charAt(j);

                /* Decrease its count in the hashmap */
                hm.put(leftChar, hm.get(leftChar) - 1);
                
                /* If its count becomes zero, remove it from the hashmap */
                if(hm.get(leftChar) == 0)  {
                    hm.remove(leftChar);
                }
                /* Move the left pointer (j) 
                to shrink the window */
                j++;
            }
        }
        return count;
    }
}