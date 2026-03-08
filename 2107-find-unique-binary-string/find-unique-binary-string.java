class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Get the i-th character of the i-th string
            char currentChar = nums[i].charAt(i);
            
            // Flip it: if '0' make it '1', if '1' make it '0'
            sb.append(currentChar == '0' ? '1' : '0');
        }
        
        return sb.toString();
    }
}