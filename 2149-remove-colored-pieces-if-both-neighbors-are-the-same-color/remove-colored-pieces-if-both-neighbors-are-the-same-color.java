class Solution 
{
    public boolean winnerOfGame(String colors) 
    {
        // Create two stack for character A and B
        Stack<Character> sk_a = new Stack<Character>();
        Stack<Character> sk_b = new Stack<Character>();

        // Iterate string
        for(int i=0; i<colors.length()-2; i++)
        {
            // If character is 'A' then
            // Check character at index i is equal to character at index i+1
            // Check character at index i+1 is equal to charactre at index i+2
            if (colors.charAt(i) == 'A' && colors.charAt(i) == colors.charAt(i+1) && 
                    colors.charAt(i+1) == colors.charAt(i+2))
                    {
                        sk_a.push('A');
                    }
            
            else if (colors.charAt(i) == 'B' && colors.charAt(i) == colors.charAt(i+1) && 
                    colors.charAt(i+1) == colors.charAt(i+2))
                    {
                        sk_b.push('B');
                    }
        }

        while(!sk_a.isEmpty() || !sk_b.isEmpty())
        {
            if (sk_a.isEmpty())
                return false;
            
            if (sk_b.isEmpty())
                return true;

            sk_a.pop();
            sk_b.pop();
        }
        return false;
    }
}