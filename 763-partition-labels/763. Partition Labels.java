class Solution {
    public List<Integer> partitionLabels(String s) {
        
        /* Array to store the last occurrence index of each character */
        int[] charAlpha = new int[26];  

        /* Populate the array with the last index of each character */
        for (int i = 0; i < s.length(); i++) {
            charAlpha[s.charAt(i) - 'a'] = i;
        }

        /* Initialize variables to track the start and end of partitions and
        List to store the sizes of partitions */
        int partitionStart = 0, partitionEnd = 0;
        List<Integer> partitionSizes = new ArrayList<>();

        /* Iterate through the string to determine partitions */
        for (int i = 0; i < s.length(); i++) {
            
            /* Update the partition end to the 
            farthest last occurrence of the current character */
            partitionEnd = Math.max(partitionEnd, charAlpha[s.charAt(i) - 'a']);

            /* If the current index matches the partition end, 
            we found a partition */
            if (i == partitionEnd) {
                
                partitionSizes.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return partitionSizes;
    }
}