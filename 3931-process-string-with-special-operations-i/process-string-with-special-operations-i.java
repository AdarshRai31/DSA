class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                res.append(res.toString());
            } else if (ch == '%') {
                res.reverse();
            } else if (ch == '*') {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}