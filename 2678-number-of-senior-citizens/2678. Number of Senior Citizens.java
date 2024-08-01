class Solution {
    public int countSeniors(String[] details) {
        // Initialize count variable
        int count = 0;
        // Iterate untill all passengers are added
        for (String str : details) {

            String sub_str = str.substring(11,13);
            int age = Integer.parseInt(sub_str);

            if (age > 60)
                count++;
        }
        return count;
    }
}