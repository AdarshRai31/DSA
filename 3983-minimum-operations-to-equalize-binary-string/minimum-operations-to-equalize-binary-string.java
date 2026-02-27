import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') initialZeros++;
        }

        if (initialZeros == 0) return 0;

        // dist[i] stores min operations to reach i zeros
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[initialZeros] = 0;

        // Use two TreeSet or custom linked structures to store unvisited nodes
        // to skip already visited states in O(log N) or O(1)
        TreeSet<Integer> evenUnvisited = new TreeSet<>();
        TreeSet<Integer> oddUnvisited = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i == initialZeros) continue;
            if (i % 2 == 0) evenUnvisited.add(i);
            else oddUnvisited.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialZeros);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            
            // Calculate the range of possible next zeros [minNext, maxNext]
            // From earlier: nextZeros = i + k - 2x
            // x_min = max(0, k - (n - i)), x_max = min(i, k)
            int minNext = i + k - 2 * Math.min(i, k);
            int maxNext = i + k - 2 * Math.max(0, k - (n - i));

            // All next states have the same parity as (i + k)
            TreeSet<Integer> targetSet = ((i + k) % 2 == 0) ? evenUnvisited : oddUnvisited;
            
            // Find all unvisited nodes in [minNext, maxNext]
            Integer next = targetSet.ceiling(minNext);
            while (next != null && next <= maxNext) {
                if (next == 0) return dist[i] + 1;
                
                dist[next] = dist[i] + 1;
                queue.add(next);
                
                // Remove from unvisited so we never process it again
                targetSet.remove(next);
                
                // Get the next available node in the range
                next = targetSet.ceiling(minNext);
            }
        }

        return -1;
    }
}