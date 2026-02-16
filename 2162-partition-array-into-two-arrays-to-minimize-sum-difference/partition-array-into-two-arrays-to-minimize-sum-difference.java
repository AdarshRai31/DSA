import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = Arrays.stream(nums).sum();
        
        // Maps to store: number of elements used -> list of possible sums
        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        
        generate(Arrays.copyOfRange(nums, 0, n), 0, 0, 0, leftMap);
        generate(Arrays.copyOfRange(nums, n, 2 * n), 0, 0, 0, rightMap);
        
        int minDiff = Integer.MAX_VALUE;
        
        // For each possible number of elements taken from the left half
        for (int k = 0; k <= n; k++) {
            List<Integer> leftSums = leftMap.get(k);
            List<Integer> rightSums = rightMap.get(n - k);
            Collections.sort(rightSums);
            
            for (int a : leftSums) {
                // We want a + b to be as close to totalSum / 2 as possible
                int target = totalSum / 2 - a;
                
                // Binary search for the best b in rightSums
                int idx = Collections.binarySearch(rightSums, target);
                if (idx < 0) idx = -(idx + 1);
                
                // Check the closest element at idx
                if (idx < rightSums.size()) {
                    int b = rightSums.get(idx);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
                }
                // Check the closest element at idx - 1
                if (idx > 0) {
                    int b = rightSums.get(idx - 1);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
                }
                
                if (minDiff == 0) return 0; // Optimization
            }
        }
        
        return minDiff;
    }
    
    private void generate(int[] arr, int i, int count, int sum, Map<Integer, List<Integer>> map) {
        if (i == arr.length) {
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
            return;
        }
        // Pick the current number
        generate(arr, i + 1, count + 1, sum + arr[i], map);
        // Don't pick the current number
        generate(arr, i + 1, count, sum, map);
    }
}