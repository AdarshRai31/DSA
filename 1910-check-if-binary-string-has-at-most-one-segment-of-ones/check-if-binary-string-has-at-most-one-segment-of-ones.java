class Solution {
    public boolean checkOnesSegment(String s) {
        String[] str = s.split("0");
        if(str.length <= 2 && (str.length < 2 || str[1].isEmpty() || str[0].isEmpty())) {
            return true;
        }
        return false;
    }
}