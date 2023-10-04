class Solution 
{
    public String intToRoman(int num) 
    {
        // Create HashMap to store roman equivalent of integer
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        // Create an array to store integers
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        String str = "";
        // Iterate array nums[]
        for(int ele : nums)
        {
            // While loop till n >= num[i]
            while(num >= ele)
            {
                // Add equivalent string for HashMap
		        // Substract that array element from n
                str += map.get(ele);
                num -= ele;
            }
        }
        // Return string
        return str;
    }
}