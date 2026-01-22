class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int max = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] > max) {
                max = costs[i];
            }
        }

        int[] arr = new int[max + 1];

        for (int i = 0; i < costs.length; i++) {
            arr[costs[i]]++;
        }

        int n = 0;
        for (int i = 0; i <= max && coins > 0; i++) {
            if (arr[i] > 0 && i <= coins) {
                int can = Math.min(arr[i], coins / i);
                n += can;
                coins = coins - i * can;
            }
        }
        return n;
    }
}