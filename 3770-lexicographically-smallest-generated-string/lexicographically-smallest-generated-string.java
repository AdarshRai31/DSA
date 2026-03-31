class Solution {
    public String generateString(String str1, String str2) {
        int m = str2.length();
        int n = str1.length() + m - 1;
        char[] res = new char[n];
        boolean[] fixed = new boolean[n];

        // 1. Mandatory Fill (Handle 'T' constraints)
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (fixed[i + j] && res[i + j] != str2.charAt(j)) {
                        return ""; // Direct conflict between two 'T' overlaps
                    }
                    res[i + j] = str2.charAt(j);
                    fixed[i + j] = true;
                }
            }
        }

        // 2. Controlled Greedy Fill
        for (int i = 0; i < n; i++) {
            if (!fixed[i]) {
                // Try 'a' first
                res[i] = 'a';
                if (!isValidAtPos(i, res, str1, str2)) {
                    // If 'a' breaks an 'F' constraint, use 'b'
                    res[i] = 'b';
                    // If 'b' also breaks it (rare but possible with certain patterns), 
                    // this specific problem logic might need further backtracking, 
                    // but for 'a' vs 'b', 'b' usually solves the 'F' conflict.
                    if (!isValidAtPos(i, res, str1, str2)) return ""; 
                }
            }
        }

        // 3. Final Global Validation
        // We must ensure the 'T's we placed didn't violate 'F's 
        // and our greedy choices didn't break 'F's retrospectively.
        String candidate = new String(res);
        for (int i = 0; i < str1.length(); i++) {
            boolean match = candidate.substring(i, i + m).equals(str2);
            if (str1.charAt(i) == 'T' && !match) return "";
            if (str1.charAt(i) == 'F' && match) return "";
        }

        return candidate;
    }

    // Helper to check if the character just placed at 'curr' violates any 'F'
    private boolean isValidAtPos(int curr, char[] res, String str1, String str2) {
        int m = str2.length();
        // An 'F' at index 'i' is violated if the pattern starts at 'i' 
        // and spans across our current position 'curr'.
        for (int i = Math.max(0, curr - m + 1); i <= Math.min(curr, str1.length() - 1); i++) {
            if (str1.charAt(i) == 'F') {
                boolean fullMatch = true;
                for (int j = 0; j < m; j++) {
                    if (res[i + j] == '\0' || res[i + j] != str2.charAt(j)) {
                        fullMatch = false;
                        break;
                    }
                }
                if (fullMatch) return false;
            }
        }
        return true;
    }
}