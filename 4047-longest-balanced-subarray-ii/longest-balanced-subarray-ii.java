class Solution {
    class SegmentTree {
        int[] min, max, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            min = new int[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
        }

        private void apply(int node, int val) {
            min[node] += val;
            max[node] += val;
            lazy[node] += val;
        }

        private void push(int node) {
            if (lazy[node] != 0) {
                apply(node * 2, lazy[node]);
                apply(node * 2 + 1, lazy[node]);
                lazy[node] = 0;
            }
        }

        private void pull(int node) {
            min[node] = Math.min(min[node * 2], min[node * 2 + 1]);
            max[node] = Math.max(max[node * 2], max[node * 2 + 1]);
        }

        void update(int node, int start, int end, int l, int r, int val) {
            if (l > r || start > r || end < l) return;
            if (start >= l && end <= r) {
                apply(node, val);
                return;
            }
            push(node);
            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);
            pull(node);
        }

        int findLeftmost(int node, int start, int end, int target) {
            if (target < min[node] || target > max[node]) return -1;
            if (start == end) return start;
            push(node);
            int mid = (start + end) / 2;
            int res = findLeftmost(node * 2, start, mid, target);
            if (res == -1) res = findLeftmost(node * 2 + 1, mid + 1, end, target);
            return res;
        }
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        SegmentTree st = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int val = (nums[i] % 2 == 0) ? 1 : -1;

            if (lastSeen.containsKey(nums[i])) {
                int prevIdx = lastSeen.get(nums[i]);
                st.update(1, 0, n - 1, 0, prevIdx, -val);
            }

            st.update(1, 0, n - 1, 0, i, val);
            lastSeen.put(nums[i], i);

            int leftmost = st.findLeftmost(1, 0, n - 1, 0);
            if (leftmost != -1 && leftmost <= i) {
                maxLen = Math.max(maxLen, i - leftmost + 1);
            }
        }
        return maxLen;
    }
}