class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int sum = 0;
        for(int i =0; i< gain.length; i++) {
            sum += gain[i];
            if(altitude < sum) {
                altitude = sum;
            }
        }
        return altitude;
    }
}