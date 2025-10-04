class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    public void combination(List<List<Integer>> result, List<Integer> valid, int n, int k, int s) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList(valid));
            return;
        }

        if (k == 0 || n < 0) return;

        for (int i = s; i <= 9; i++) {
            valid.add(i);
            combination(result, valid, n - i, k - 1, i + 1);
            valid.removeLast();
        }
    }
}