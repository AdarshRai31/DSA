class Solution {
    public char findKthBit(int n, int k) {
        String Sn = str(n);
        return Sn.charAt(k-1);
    }

    public String str(int n) {
        if (n == 1) {
            return "0";
        }
        return str(n-1) + "1" + invert(str(n-1)).reverse();
    }

    private StringBuilder invert(String str) {
        StringBuilder comp = new StringBuilder();

        for (char bit : str.toCharArray()) {
            if (bit == '0') {
                comp.append('1');
            }
            else {
                comp.append('0');
            }
        }
        return comp;
    }
}