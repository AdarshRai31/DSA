class Solution {
    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        int index = 1;
        int freq = 0;
        int count = 1;

        while (index <= chars.length) {
            if (index < chars.length && chars[index - 1] == chars[index]) {
                count++;
            }
            else {
                chars[freq++] = chars[index - 1];
                if (count != 1) {
                    String digit = count + "";
                    int c = 0;
                    while (c != digit.length()) {
                        chars[freq] = digit.charAt(c);
                        freq++;
                        c++;
                    }
                }
                count = 1;
            }
            index++;
        }
        return freq;
    }
}