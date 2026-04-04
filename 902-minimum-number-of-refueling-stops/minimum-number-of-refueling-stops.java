class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int count = 0;
        boolean[] used = new boolean[stations.length];

        while (startFuel < target) {
            int index = -1;
            int max = -1;
            for (int i = 0; i < stations.length; i++) {
                if (!used[i] && stations[i][0] <= startFuel) {
                    if (stations[i][1] > max) {
                        max = stations[i][1];
                        index = i;
                    }
                }
            }

            if (index == -1) {
                return -1;
            }

            startFuel += max;
            used[index] = true;
            count++;
        }
        return count; 
    }
}