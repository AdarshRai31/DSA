class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  

        int count = 0;
        int i = 0;

        while (startFuel < target) {

            while (i < stations.length && stations[i][0] <= startFuel) {
                pq.offer(stations[i][1]);
                i++;
            }

            if (pq.isEmpty()) {
                return -1;
            }

            startFuel += pq.poll();
            count++;
        }
        return count; 
    }
}