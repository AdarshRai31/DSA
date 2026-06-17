class Solution {
    public char processStr(String s, long k) {
        long l = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                l = l > 0 ? l - 1 : l;
            }
            else if (ch == '#') {
                l = l * 2;
            } else if (ch == '%') {
                continue;
            } else {
                l++;
            }
        }

        if (k >= l) {
            return '.';
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            
            if (ch == '*') {
                l++;
            } else if (ch == '#') {
                l = l / 2;
                k = (k >= l) ? k - l : k;
            } else if (ch == '%') {
                k = l - k - 1;
            } else {
                l--;
            }

            if (l == k) {
                return ch;
            }
        }

        return '.';
    }
}