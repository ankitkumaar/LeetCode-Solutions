class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();

        /* If there's only one friend, the entire word is the answer */
        if (numFriends == 1) 
            return word;

        /* 'res' To store the lexicographically largest substring &
        'len' Length of each substring to consider */
        String res = "";
        int len = word.length() - numFriends + 1;

        /* Iterate through each character in the word */
        for (int i = 0; i < n; i++) {
            String str;

            /* If the substring from i to i+len fits within the word */
            if (i + len <= n)
                str = word.substring(i, i + len);
            else
                str = word.substring(i);

            /* Update result if the current substring is 
            lexicographically greater */
            if (str.compareTo(res) > 0)
                res = str;
        }
        return res;
    }
}
